package com.leetcode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class PackageScan {

    /**
     * 类加载器
     */
    private static ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    /**
     * 系统相关的文件路径分隔符 \或/
     */
    private static final String FILE_SEPARATOR = File.separator;

    /**
     * 从指定的java包路径下扫描Class对象
     *
     * @param packageName 包路径名,必须从根路径写起。例如“com.test”
     * @return
     * @throws IOException
     */
    public static List<Class<?>> scanClass(String packageName) throws IOException {
        ArrayList<Class<?>> classList = new ArrayList<Class<?>>();
        for (String className : scanClassName(packageName)) {
            try {
                classList.add(Class.forName(className));
            } catch (ClassNotFoundException e) {
                // 由于所有的className都是我们自己扫描而来的。所以不会出现ClassNotFoundException，所以此处将ClassNotFoundException对外屏蔽掉
                e.printStackTrace();
            }
        }
        return classList;
    }

    /**
     * 从指定的java包路径下扫描className
     *
     * @param packageName 包路径名。例如“com.test”
     * @return
     * @throws IOException
     */
    public static List<String> scanClassName(String packageName) throws IOException {
        // 将包路径分隔符由.替换成ClassLoader可以识别的/
        String packagePath = packageName.replace(".", "/");
        // 通过类加载器获得资源对象
        URL resource = classLoader.getResource(packagePath);

        // 获取资源路径字符串。
        // jar的path例如：file:/D:/WorkProgram/workspace/Test/lib/commons-codec-1.4.jar!/org/apache/commons/codec
        // 文件夹的path例如：/D:/WorkProgram/workspace/Test/bin/test/util
        String path = resource.getPath();
        List<String> classNames = null;
        // 对不同的资源类型分别处理
        if ("jar".equalsIgnoreCase(resource.getProtocol())) {
            // 截取jar包所在路径。例如：/D:/commons-codec-1.4.jar
            String jarPath = path.substring("file:".length(), path.indexOf(packagePath) - 2);
            classNames = scanJarFileClassName(jarPath, packagePath);
        } else {
            // 不是jar包，使用系统路径分隔符进行查找
            classNames = scanDirectoryClassName(path, packagePath.replace("/", FILE_SEPARATOR));
        }
        return classNames;
    }

    /**
     * 从jar包里读取指定包名下的class文件
     *
     * @param jarFilePath jar包所在路径
     * @param packagePath 要扫描的路径
     * @return
     * @throws IOException
     */
    private static List<String> scanJarFileClassName(String jarFilePath, String packagePath) throws IOException {
        // 使用JarInputStream读取jar包内容
        try (JarInputStream jarIn = new JarInputStream(new FileInputStream(jarFilePath))) {
            List<String> nameList = new ArrayList<String>();
            for (JarEntry entry = jarIn.getNextJarEntry(); entry != null; entry = jarIn.getNextJarEntry()) {
                String name = entry.getName();
                if (name.startsWith(packagePath) && name.endsWith(".class")) {
                    // java的文件路径分隔符为/，故此处写死
                    nameList.add(name.replace("/", "."));
                }
            }
            return nameList;
        }
    }

    /**
     * 从文件夹里读取指定的Class文件
     *
     * @param directoryPath 文件夹路径
     * @param packagePath   要扫描的路径
     * @return
     */
    private static List<String> scanDirectoryClassName(String directoryPath, String packagePath) {
        List<String> nameList = new ArrayList<String>();
        for (File file : new File(directoryPath).listFiles()) {
            String path = file.getPath();
            if (file.isDirectory()) {
                // 如果是文件夹，则递归扫描
                List<String> scanDirectoryClassName = scanDirectoryClassName(path, packagePath);
                nameList.addAll(scanDirectoryClassName);
            } else if (file.isFile() && file.getName().endsWith(".class")) {
                // 从packetPath截取路径，并将系统路径分隔符替换为.
                String classFileName = path.substring(path.indexOf(packagePath)).replace(FILE_SEPARATOR, ".");
                String className = classFileName.replaceFirst("\\.class$", "");
                nameList.add(className);
            }
        }
        return nameList;
    }
}