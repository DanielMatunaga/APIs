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

/**
 * Service that can be used anywhere to get request information.
 */
public interface RequestContext
{
    /**
     * Gets request path variables by its name.
     *
     * @param name The name of the path variable.
     * @return requestPathVariable The request path variable.s
     */
    int getRequestPathVariables(String name);
}
