package org.autocore.java.rest.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.autocore.java.commons.utils.exception.RuntimeInterruptionException;
import org.autocore.java.rest.uri.EndpointFactory;
import org.autocore.java.rest.uri.KeyValue;

import java.io.IOException;
import java.util.List;

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
public class Request {

    private CloseableHttpClient httpClient;
    private String endpoint;
    private HttpResponse res;
    private HttpGet get;
    private HttpPost post;
    private HttpPut put;
    private HttpDelete delete;


    /**
     * Constructor For Rest Request Helper Class.
     *
     * @param httpClient - http client instance
     */
    public Request(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Constructor For Rest Request Helper Class.
     *
     * @param httpClient - http client instance
     * @param endpoint - base endpoint to make request (no query)
     */
    public Request(CloseableHttpClient httpClient, String endpoint) {
        this.httpClient = httpClient;
        this.endpoint = endpoint;
    }

    /**
     * Method used to make a GET Request.
     *
     * @return Http Response
     */
    public HttpResponse getRequest() {
        try {
            get = new HttpGet(endpoint);
            res = httpClient.execute(get);

        } catch (IOException e) {
            throw new RuntimeInterruptionException("Could not make GET request to " + endpoint);
        }
        return res;

    }

    /**
     * Method used to make a GET Request.
     *
     * @param key - key to pass in
     * @param value - pair to pass in
     * @return Http Response
     */
    public HttpResponse getRequest(String key, String value) {
        try {
            EndpointFactory endpointFactory = new EndpointFactory(endpoint);

            endpoint = endpointFactory.buildURI(key, value);
            get = new HttpGet(endpoint);

            res = httpClient.execute(get);

        } catch (IOException e) {
            throw new RuntimeInterruptionException("Could not make GET request to " + endpoint);
        }
        return res;

    }

    /**
     * Method used to make a GET Request.
     *
     * @param keyValue - key/value pair to pass in
     * @return Http Response
     */
    public HttpResponse getRequest(KeyValue keyValue) {
        try {
            EndpointFactory endpointFactory = new EndpointFactory(endpoint);

            endpoint = endpointFactory.buildURI(keyValue);
            get = new HttpGet(endpoint);

            res = httpClient.execute(get);

        } catch (IOException e) {
            throw new RuntimeInterruptionException("Could not make GET request to " + endpoint);
        }
        return res;

    }

    /**
     * Method used to make a GET Request.
     *
     * @param keyValue - list of key/value pairs to pass in
     * @return Http Response
     */
    public HttpResponse getRequest(List<KeyValue> keyValue) {
        try {
            EndpointFactory endpointFactory = new EndpointFactory(endpoint);

            endpoint = endpointFactory.buildURI(keyValue);
            get = new HttpGet(endpoint);

            res = httpClient.execute(get);

        } catch (IOException e) {
            throw new RuntimeInterruptionException("Could not make GET request to " + endpoint);
        }
        return res;

    }

    /**
     * Method used to make a POST Request.
     *
     * @param httpEntity - POJO representation of a JSON Object
     * @return Http Response
     */
    public HttpResponse postRequest(HttpEntity httpEntity) {
        try {
            post = new HttpPost(endpoint);
            post.setEntity(httpEntity);
            post.setHeader("Content-type", "application/json");

            res = httpClient.execute(post);

        } catch (IOException e) {
            throw new RuntimeInterruptionException("Could not make POST request to " + endpoint);
        }
        return res;

    }

    /**
     * Method used to make a DELETE Request.
     *
     * @return Http Response
     */
    public HttpResponse deleteRequest() {
        try {
            delete = new HttpDelete(endpoint);

            res = httpClient.execute(delete);

        } catch (IOException e) {
            throw new RuntimeInterruptionException("Could not make DELETE request to " + endpoint);
        }
        return res;

    }

    /**
     * Method used to make a PUT Request.
     *
     * @return Http Response
     */
    public HttpResponse putRequest() {
        try {
            put = new HttpPut(endpoint);

            res = httpClient.execute(put);

        } catch (IOException e) {
            throw new RuntimeInterruptionException("Could not make PUT request to " + endpoint);
        }
        return res;

    }

    /**
     * Method used to make a PUT Request.
     *
     * @param httpEntity - POJO representation of a JSON Object
     * @return Http Response
     */
    public HttpResponse putRequest(HttpEntity httpEntity) {
        try {
            put = new HttpPut(endpoint);
            put.setEntity(httpEntity);
            put.setHeader("Content-type", "application/json");

            res = httpClient.execute(put);

        } catch (IOException e) {
            throw new RuntimeInterruptionException("Could not make PUT request to " + endpoint);
        }
        return res;

    }
}