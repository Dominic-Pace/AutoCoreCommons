package org.autocore.java.rest.uri;

import org.apache.http.client.utils.URIBuilder;
import org.autocore.java.commons.utils.exception.RuntimeInterruptionException;

import java.net.URI;
import java.net.URISyntaxException;
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
public class EndpointFactory {

    String baseEndpoint;
    URI uri;

    /**
     * Constructor for Endpoint Factory
     * @param baseEndpoint base endpoint/URL for URI
     */
    public EndpointFactory(String baseEndpoint) {
        this.baseEndpoint = baseEndpoint;
    }

    /**
     * Method used to build a URI from a key and value pair given a base URI.
     *
     * @param key - representation of "query name"
     * @param value - representation of "query value"
     * @return String representation of URI
     */
    public String buildURI(String key, String value) {
        try {
            uri = new URIBuilder(baseEndpoint)
                    .setParameter(key, value)
                    .build();

            return uri.toString();

        } catch (URISyntaxException e) {
            throw new RuntimeInterruptionException("Could not create new URI " + uri.toString());
        }
    }

    /**
     * Method used to build a URI from a key and value pair given a base URI.
     *
     * @param keyValuePair - representation of the query name and value.
     * @return String representation of URI
     */
    public String buildURI(KeyValue keyValuePair) {

        try {
            uri = new URIBuilder(baseEndpoint)
                    .setParameter(keyValuePair.getKey(), keyValuePair.getValue())
                    .build();

            return uri.toString();

        } catch (URISyntaxException e) {
            throw new RuntimeInterruptionException("Could not create new URI " + uri.toString());
        }
    }

    /**
     * Method used to build a URI from a list of key and value pairs given a base URI.
     *
     * @param keyValueList - list representations of the query name and value.
     * @return String representation of URI
     */
    public String buildURI(List<KeyValue> keyValueList) {
        try {
            URIBuilder builder = new URIBuilder(baseEndpoint);

            for(int i = 0; i < keyValueList.size(); i++) {
                builder.setParameter(keyValueList.get(i).getKey(), keyValueList.get(i).getValue());
            }
            uri = builder.build();

            return uri.toString();

        } catch (URISyntaxException e) {
            throw new RuntimeInterruptionException("Could not create new URI " + uri.toString());
        }
    }
}
