/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information. 
 */

package com.microsoft.azure.keyvault.webkey;

import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * As of http://tools.ietf.org/html/draft-ietf-jose-json-web-key-18.
 */
@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY, setterVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
public class JsonWebKey {

    /**
     * Key Identifier.
     */
    private String kid;

    /**
     * Key type, usually RSA. Possible values include: 'EC', 'RSA', 'RSA-HSM',
     * 'oct'.
     */
    private JsonWebKeyType kty;

    /**
     * The keyOps property.
     */
    private List<JsonWebKeyOperation> keyOps;

    /**
     * RSA modulus.
     */
    private byte[] n;

    /**
     * RSA public exponent.
     */
    private byte[] e;

    /**
     * RSA private exponent.
     */
    private byte[] d;

    /**
     * RSA Private Key Parameter.
     */
    private byte[] dp;

    /**
     * RSA Private Key Parameter.
     */
    private byte[] dq;

    /**
     * RSA Private Key Parameter.
     */
    private byte[] qi;

    /**
     * RSA secret prime.
     */
    private byte[] p;

    /**
     * RSA secret prime, with p &lt; q.
     */
    private byte[] q;

    /**
     * Symmetric key.
     */
    private byte[] k;

    /**
     * HSM Token, used with Bring Your Own Key.
     */
    private byte[] t;

    /**
     * Key Identifier.
     *
     * @return the kid value.
     */
    @JsonProperty("kid")
    public String kid() {
        return this.kid;
    }

    /**
     * Set the key identifier value.
     *
     * @param kid the key identifier
     * @return the JsonWebKey object itself.
     */
    public JsonWebKey withKid(String kid) {
        this.kid = kid;
        return this;
    }

    /**
     * Key type, usually RSA. Possible values include: 'EC', 'RSA', 'RSA-HSM',
     * 'oct'.
     *
     * @return the key type.
     */
    @JsonProperty("kty")
    public JsonWebKeyType kty() {
        return this.kty;
    }

    /**
     * Set the key type value.
     *
     * @param kty the key type
     * @return the JsonWebKey object itself.
     */
    public JsonWebKey withKty(JsonWebKeyType kty) {
        this.kty = kty;
        return this;
    }

    /**
     * Get the key operations.
     *
     * @return the key operations.
     */
    @JsonProperty("key_ops")
    public List<JsonWebKeyOperation> keyOps() {
        return this.keyOps;
    }

    /**
     * Set the key operations value.
     *
     * @param keyOps the key operations value to set
     * @return the JsonWebKey object itself.
     */
    public JsonWebKey withKeyOps(List<JsonWebKeyOperation> keyOps) {
        this.keyOps = keyOps;
        return this;
    }

    /**
     * Get the RSA modulus value.
     *
     * @return the RSA modulus value.
     */
    @JsonProperty("n")
    @JsonSerialize(using = Base64UrlJsonSerializer.class)
    @JsonDeserialize(using = Base64UrlJsonDeserializer.class)
    public byte[] n() {
        return this.n;
    }

    /**
     * Set the RSA modulus value.
     *
     * @param n the RSA modulus value to set
     * @return the JsonWebKey object itself.
     */
    public JsonWebKey withN(byte[] n) {
        this.n = n;
        return this;
    }

    /**
     * Get the RSA public exponent value.
     * @return the RSA public exponent value.
     */
    @JsonProperty("e")
    @JsonSerialize(using = Base64UrlJsonSerializer.class)
    @JsonDeserialize(using = Base64UrlJsonDeserializer.class)
    public byte[] e() {
        return this.e;
    }

    /**
     * Set the RSA public exponent value.
     * 
     * @param e RSA public exponent value to set
     * @return the JsonWebKey object itself.
     */
    public JsonWebKey withE(byte[] e) {
        this.e = e;
        return this;
    }

    /**
     * Get the RSA private exponent value.
     * @return the RSA private exponent value.
     */
    @JsonProperty("d")
    @JsonSerialize(using = Base64UrlJsonSerializer.class)
    @JsonDeserialize(using = Base64UrlJsonDeserializer.class)
    public byte[] d() {
        return this.d;
    }

    /**
     * Set RSA private exponent value.
     * 
     * @param d the RSA private exponent value to set.
     * @return the JsonWebKey object itself.
     */
    public JsonWebKey withD(byte[] d) {
        this.d = d;
        return this;
    }

    /**
     * Get the RSA Private Key Parameter value.
     * @return the RSA Private Key Parameter value.
     */
    @JsonProperty("dp")
    @JsonSerialize(using = Base64UrlJsonSerializer.class)
    @JsonDeserialize(using = Base64UrlJsonDeserializer.class)
    public byte[] dp() {
        return this.dp;
    }

    /**
     * Set RSA Private Key Parameter value.
     * @param dp the RSA Private Key Parameter value to set.
     * @return the JsonWebKey object itself.
     */
    public JsonWebKey withDp(byte[] dp) {
        this.dp = dp;
        return this;
    }

    /**
     * Get the RSA Private Key Parameter value.
     * @return the RSA Private Key Parameter value.
     */
    @JsonProperty("dq")
    @JsonSerialize(using = Base64UrlJsonSerializer.class)
    @JsonDeserialize(using = Base64UrlJsonDeserializer.class)
    public byte[] dq() {
        return this.dq;
    }

    /**
     * Set RSA Private Key Parameter value .
     * @param dq the RSA Private Key Parameter value to set.
     * @return the JsonWebKey object itself.
     */
    public JsonWebKey withDq(byte[] dq) {
        this.dq = dq;
        return this;
    }

    /**
     * Get the RSA Private Key Parameter value.
     * @return the RSA Private Key Parameter value.
     */
    @JsonProperty("qi")
    @JsonSerialize(using = Base64UrlJsonSerializer.class)
    @JsonDeserialize(using = Base64UrlJsonDeserializer.class)
    public byte[] qi() {
        return this.qi;
    }

    /**
     * Set RSA Private Key Parameter value.
     * @param qi the RSA Private Key Parameter value to set.
     * @return the JsonWebKey object itself.
     */
    public JsonWebKey withQi(byte[] qi) {
        this.qi = qi;
        return this;
    }

    /**
     * Get the RSA secret prime value.
     * @return the RSA secret prime value.
     */
    @JsonProperty("p")
    @JsonSerialize(using = Base64UrlJsonSerializer.class)
    @JsonDeserialize(using = Base64UrlJsonDeserializer.class)
    public byte[] p() {
        return this.p;
    }

    /**
     * Set the RSA secret prime value.
     * @param p the RSA secret prime value.
     * @return the JsonWebKey object itself.
     */
    public JsonWebKey withP(byte[] p) {
        this.p = p;
        return this;
    }

    /**
     * Get RSA secret prime, with p &lt; q value.
     * @return the RSA secret prime, with p &lt; q value.
     */
    @JsonProperty("q")
    @JsonSerialize(using = Base64UrlJsonSerializer.class)
    @JsonDeserialize(using = Base64UrlJsonDeserializer.class)
    public byte[] q() {
        return this.q;
    }

    /**
     * Set the RSA secret prime, with p &lt; q value.
     * @param q the the RSA secret prime, with p &lt; q value to be set.
     * @return the JsonWebKey object itself.
     */
    public JsonWebKey withQ(byte[] q) {
        this.q = q;
        return this;
    }

    /**
     * Get Symmetric key value.
     * @return the symmetric key value.
     */
    @JsonProperty("k")
    @JsonSerialize(using = Base64UrlJsonSerializer.class)
    @JsonDeserialize(using = Base64UrlJsonDeserializer.class)
    public byte[] k() {
        return this.k;
    }

    /**
     * Set the Symmetric key value.
     * @param k the symmetric key value to set.
     * @return the JsonWebKey object itself.
     */
    public JsonWebKey withK(byte[] k) {
        this.k = k;
        return this;
    }

    /**
     * Get HSM Token value, used with Bring Your Own Key.
     * @return HSM Token, used with Bring Your Own Key.
     */
    @JsonProperty("key_hsm")
    @JsonSerialize(using = Base64UrlJsonSerializer.class)
    @JsonDeserialize(using = Base64UrlJsonDeserializer.class)
    public byte[] t() {
        return this.t;
    }

    /**
     * Set HSM Token value, used with Bring Your Own Key.
     * @param t HSM Token value to set, used with Bring Your Own Key
     * @return the JsonWebKey object itself.
     */
    public JsonWebKey withT(byte[] t) {
        this.t = t;
        return this;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonGenerationException e) {
            throw new IllegalStateException(e);
        } catch (JsonMappingException e) {
            throw new IllegalStateException(e);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Get the RSA public key spec value.
     *
     * @return the RSA public key spec value
     */
    private RSAPublicKeySpec getRSAPublicKeySpec() {

        return new RSAPublicKeySpec(toBigInteger(n()), toBigInteger(e()));
    }

    /**
     * Get the RSA private key spec value.
     *
     * @return the RSA private key spec value
     */
    private RSAPrivateKeySpec getRSAPrivateKeySpec() {

        return new RSAPrivateCrtKeySpec(toBigInteger(n()), toBigInteger(e()), toBigInteger(d()), toBigInteger(p()),
                toBigInteger(q()), toBigInteger(dp()), toBigInteger(dq()), toBigInteger(qi()));
    }

    /**
     * Get the RSA public key value.
     *
     * @param provider the Java security provider.
     * @return the RSA public key value
     */
    private PublicKey getRSAPublicKey(Provider provider) {

        try {
            RSAPublicKeySpec publicKeySpec = getRSAPublicKeySpec();
            KeyFactory       factory       = provider != null ? KeyFactory.getInstance("RSA", provider) : KeyFactory.getInstance("RSA");

            return factory.generatePublic(publicKeySpec);
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Get the RSA private key value.
     *
     * @param provider the Java security provider.
     * @return the RSA private key value
     */
    private PrivateKey getRSAPrivateKey(Provider provider) {

        try {
            RSAPrivateKeySpec privateKeySpec = getRSAPrivateKeySpec();
            KeyFactory        factory       = provider != null ? KeyFactory.getInstance("RSA", provider) : KeyFactory.getInstance("RSA");

            return factory.generatePrivate(privateKeySpec);
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Verifies if the key is an RSA key.
     */
    private void checkRSACompatible() {
        if (!JsonWebKeyType.RSA.equals(kty()) && !JsonWebKeyType.RSA_HSM.equals(kty())) {
            throw new UnsupportedOperationException("Not an RSA key");
        }
    }

    private static byte[] toByteArray(BigInteger n) {
        byte[] result = n.toByteArray();
        if (result[0] == 0) {
            // The leading zero is used to let the number positive. Since RSA
            // parameters are always positive, we remove it.
            return Arrays.copyOfRange(result, 1, result.length);
        }
        return result;
    }

    private static BigInteger toBigInteger(byte[] b) {
        if (b[0] < 0) {
            // RSA parameters are always positive numbers, so if the first byte
            // is negative, we need to add a leading zero
            // to make the entire BigInteger positive.
            byte[] temp = new byte[1 + b.length];
            System.arraycopy(b, 0, temp, 1, b.length);
            b = temp;
        }
        return new BigInteger(b);
    }

    /**
     * Converts RSA key pair to JSON web key.
     * @param keyPair RSA key pair
     * @return the JSON web key, converted from RSA key pair.
     */
    public static JsonWebKey fromRSA(KeyPair keyPair) {

        RSAPrivateCrtKey privateKey = (RSAPrivateCrtKey) keyPair.getPrivate();
        JsonWebKey key = null;

        if (privateKey != null) {

            key = new JsonWebKey()
                    .withKty(JsonWebKeyType.RSA)
                    .withN(toByteArray(privateKey.getModulus()))
                    .withE(toByteArray(privateKey.getPublicExponent()))
                    .withD(toByteArray(privateKey.getPrivateExponent()))
                    .withP(toByteArray(privateKey.getPrimeP()))
                    .withQ(toByteArray(privateKey.getPrimeQ()))
                    .withDp(toByteArray(privateKey.getPrimeExponentP()))
                    .withDq(toByteArray(privateKey.getPrimeExponentQ()))
                    .withQi(toByteArray(privateKey.getCrtCoefficient()));
        } else {

            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

            key = new JsonWebKey()
                    .withKty(JsonWebKeyType.RSA)
                    .withN(toByteArray(publicKey.getModulus()))
                    .withE(toByteArray(publicKey.getPublicExponent()))
                    .withD(null)
                    .withP(null)
                    .withQ(null)
                    .withDp(null)
                    .withDq(null)
                    .withQi(null);
        }

        return key;
    }

    /**
     * Converts JSON web key to RSA key pair.
     * @return RSA key pair
     */
    public KeyPair toRSA() {
        return this.toRSA(false);
    }

    /**
     * Converts JSON web key to RSA key pair and include the private key if set to true.
     * @param includePrivateParameters true if the RSA key pair should include the private key. False otherwise.
     * @return RSA key pair
     */
    public KeyPair toRSA(boolean includePrivateParameters) {
        return toRSA(includePrivateParameters, null);
    }
    
    /**
     * Converts JSON web key to RSA key pair and include the private key if set to true.
     * @param provider the Java security provider.
     * @param includePrivateParameters true if the RSA key pair should include the private key. False otherwise.
     * @return RSA key pair
     */
    public KeyPair toRSA(boolean includePrivateParameters, Provider provider) {

        // Must be RSA
        checkRSACompatible();

        if (includePrivateParameters) {
            return new KeyPair(getRSAPublicKey(provider), getRSAPrivateKey(provider));
        } else {
            return new KeyPair(getRSAPublicKey(provider), null);
        }
    }
}