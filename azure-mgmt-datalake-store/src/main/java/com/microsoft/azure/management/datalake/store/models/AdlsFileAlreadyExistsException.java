/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datalake.store.models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * A WebHDFS exception thrown indicating the file or folder already exists.
 * Thrown when a 403 error response code is returned (forbidden).
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "exception")
@JsonTypeName("FileAlreadyExistsException")
public class AdlsFileAlreadyExistsException extends AdlsRemoteException {
}
