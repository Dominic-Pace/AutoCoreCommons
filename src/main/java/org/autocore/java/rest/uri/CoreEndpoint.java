package org.autocore.java.rest.uri;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.autocore.java.rest.utils.Request;
import org.autocore.java.rest.RestConfig;
import org.testng.Assert;

/**
 * (C) Copyright 2016 Dominic Pace (https://github.com/Dominic-Pace)
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 */
public class CoreEndpoint extends Request {

    protected RestConfig config = RestConfig.get();
    protected String restEndpoint = config.getBaseURL() + "/"
            + config.getRestAPIVersion() + "/";
    
    protected CloseableHttpClient httpClient;
    protected Request req;
    protected HttpResponse res;
    protected HttpPost post;
    protected HttpPut put;
    protected HttpGet get;
    protected HttpDelete delete;

    /**
     * Constructor For Rest Request Helper Class.
     *
     * @param httpClient - http client instance
     * @param endpoint   - base endpoint to make request (no query)
     */
    public CoreEndpoint(CloseableHttpClient httpClient, String endpoint) {
        super(httpClient, endpoint);
    }

    /**
     * Method used to assert that a response from a request is valid.
     *
     * @param res - http response
     * @return http response instance
     */
    public HttpResponse assertValidResponse(HttpResponse res) {
        Assert.assertTrue(res.getStatusLine().getStatusCode() == 200);

        return res;

    }
}
