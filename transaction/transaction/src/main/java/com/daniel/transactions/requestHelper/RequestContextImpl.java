//**********************************************************************
// Copyright (c) 2020 Telefonaktiebolaget LM Ericsson, Sweden.
// All rights reserved.
// The Copyright to the computer program(s) herein is the property of
// Telefonaktiebolaget LM Ericsson, Sweden.
// The program(s) may be used and/or copied with the written permission
// from Telefonaktiebolaget LM Ericsson or in accordance with the terms
// and conditions stipulated in the agreement/contract under which the
// program(s) have been supplied.
// **********************************************************************
package com.daniel.transactions.requestHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of requestContext service to get request information.
 */
public class RequestContextImpl implements RequestContext
{
    private static final Map<String, Integer> requestPathVariables = new HashMap<>();

    /**
     * This is hidden in the interface because we should only define it when we create the instance.
     * In this way, we avoid changing path variables after creation.
     *
     * @param name The name of the request path variable.
     * @param value The value of the request path variable.
     */
    public void setRequestPathVariable(String name, int value)
    {
        requestPathVariables.put(name, value);
    }

    @Override
    public int getRequestPathVariables(String name)
    {
        return requestPathVariables.get(name);
    }
}
