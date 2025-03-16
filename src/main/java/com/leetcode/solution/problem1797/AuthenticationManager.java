package com.leetcode.solution.problem1797;

import java.util.*;

/**
 * 设计一个验证系统
 *
 * @author Ricky
 * @date 2023-02-09 23:02:20
 */
public class AuthenticationManager {

    private final int timeToLive;

    private Set<TokenInfo> tokens = new TreeSet<>();

    private Map<String, TokenInfo> tokenInfoMap = new HashMap<>();

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        checkExpire(currentTime);
        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.token = tokenId;
        tokenInfo.expire = currentTime + timeToLive;
        tokens.add(tokenInfo);
        tokenInfoMap.put(tokenId, tokenInfo);
    }

    public void renew(String tokenId, int currentTime) {
        checkExpire(currentTime);

        TokenInfo tokenInfo = tokenInfoMap.get(tokenId);
        if (tokenInfo != null) {
            tokens.remove(tokenInfo);
            tokenInfo.expire = currentTime + timeToLive;
            tokens.add(tokenInfo);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        checkExpire(currentTime);
        return tokens.size();
    }

    private void checkExpire(int newCurrentTime) {
        Iterator<TokenInfo> iterator = tokens.iterator();
        while (iterator.hasNext()) {
            TokenInfo tokenInfo = iterator.next();
            if (newCurrentTime >= tokenInfo.expire) {
                tokenInfoMap.remove(tokenInfo.token);
                iterator.remove();
            } else {
                break;
            }
        }
    }

    public static class TokenInfo implements Comparable<TokenInfo> {

        private String token;

        private Integer expire;

        @Override
        public int compareTo(TokenInfo other) {
            return this.expire.compareTo(other.expire);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof TokenInfo)) {
                return false;
            }
            TokenInfo other = (TokenInfo) o;
            return this.token.equals(other.token);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.token);
        }
    }
}
