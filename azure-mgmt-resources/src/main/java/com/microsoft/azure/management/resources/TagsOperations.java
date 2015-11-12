/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 * 
 * Code generated by Microsoft (R) AutoRest Code Generator 0.13.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.management.resources;

import com.microsoft.azure.management.resources.models.PageImpl;
import com.microsoft.azure.management.resources.models.TagDetails;
import com.microsoft.azure.management.resources.models.TagValue;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceException;
import com.microsoft.rest.ServiceResponse;
import com.squareup.okhttp.ResponseBody;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.HTTP;
import retrofit.http.Path;
import retrofit.http.PUT;
import retrofit.http.Query;
import retrofit.http.Url;

/**
 * An instance of this class provides access to all the operations defined
 * in TagsOperations.
 */
public interface TagsOperations {
    /**
     * The interface defining all the services for TagsOperations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface TagsService {
        @HTTP(path = "/subscriptions/{subscriptionId}/tagNames/{tagName}/tagValues/{tagValue}", method = "DELETE", hasBody = true)
        Call<ResponseBody> deleteValue(@Path("tagName") String tagName, @Path("tagValue") String tagValue, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

        @PUT("/subscriptions/{subscriptionId}/tagNames/{tagName}/tagValues/{tagValue}")
        Call<ResponseBody> createOrUpdateValue(@Path("tagName") String tagName, @Path("tagValue") String tagValue, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

        @PUT("/subscriptions/{subscriptionId}/tagNames/{tagName}")
        Call<ResponseBody> createOrUpdate(@Path("tagName") String tagName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

        @HTTP(path = "/subscriptions/{subscriptionId}/tagNames/{tagName}", method = "DELETE", hasBody = true)
        Call<ResponseBody> delete(@Path("tagName") String tagName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

        @GET("/subscriptions/{subscriptionId}/tagNames")
        Call<ResponseBody> list(@Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage);

        @GET
        Call<ResponseBody> listNext(@Url String nextPageLink, @Header("accept-language") String acceptLanguage);

    }
    /**
     * Delete a subscription resource tag value.
     *
     * @param tagName The name of the tag.
     * @param tagValue The value of the tag.
     * @throws ServiceException exception thrown from REST call
     * @return the ServiceResponse object if successful.
     */
    ServiceResponse<Void> deleteValue(String tagName, String tagValue) throws ServiceException;

    /**
     * Delete a subscription resource tag value.
     *
     * @param tagName The name of the tag.
     * @param tagValue The value of the tag.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> deleteValueAsync(String tagName, String tagValue, final ServiceCallback<Void> serviceCallback);

    /**
     * Create a subscription resource tag value.
     *
     * @param tagName The name of the tag.
     * @param tagValue The value of the tag.
     * @throws ServiceException exception thrown from REST call
     * @return the TagValue object wrapped in ServiceResponse if successful.
     */
    ServiceResponse<TagValue> createOrUpdateValue(String tagName, String tagValue) throws ServiceException;

    /**
     * Create a subscription resource tag value.
     *
     * @param tagName The name of the tag.
     * @param tagValue The value of the tag.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> createOrUpdateValueAsync(String tagName, String tagValue, final ServiceCallback<TagValue> serviceCallback);

    /**
     * Create a subscription resource tag.
     *
     * @param tagName The name of the tag.
     * @throws ServiceException exception thrown from REST call
     * @return the TagDetails object wrapped in ServiceResponse if successful.
     */
    ServiceResponse<TagDetails> createOrUpdate(String tagName) throws ServiceException;

    /**
     * Create a subscription resource tag.
     *
     * @param tagName The name of the tag.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> createOrUpdateAsync(String tagName, final ServiceCallback<TagDetails> serviceCallback);

    /**
     * Delete a subscription resource tag.
     *
     * @param tagName The name of the tag.
     * @throws ServiceException exception thrown from REST call
     * @return the ServiceResponse object if successful.
     */
    ServiceResponse<Void> delete(String tagName) throws ServiceException;

    /**
     * Delete a subscription resource tag.
     *
     * @param tagName The name of the tag.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> deleteAsync(String tagName, final ServiceCallback<Void> serviceCallback);

    /**
     * Get a list of subscription resource tags.
     *
     * @throws ServiceException exception thrown from REST call
     * @return the PageImpl&lt;TagDetails&gt; object wrapped in ServiceResponse if successful.
     */
    ServiceResponse<PageImpl<TagDetails>> list() throws ServiceException;

    /**
     * Get a list of subscription resource tags.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> listAsync(final ServiceCallback<PageImpl<TagDetails>> serviceCallback);

    /**
     * Get a list of subscription resource tags.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws ServiceException exception thrown from REST call
     * @return the PageImpl&lt;TagDetails&gt; object wrapped in ServiceResponse if successful.
     */
    ServiceResponse<PageImpl<TagDetails>> listNext(String nextPageLink) throws ServiceException;

    /**
     * Get a list of subscription resource tags.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link Call} object
     */
    Call<ResponseBody> listNextAsync(String nextPageLink, final ServiceCallback<PageImpl<TagDetails>> serviceCallback);

}