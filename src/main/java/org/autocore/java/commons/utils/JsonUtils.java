package org.autocore.java.commons.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStreamReader;
import java.io.Reader;

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
public class JsonUtils {

    protected String jsonFilePath;
    protected Reader reader;
    protected Gson gson;

    public JsonUtils(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
        this.reader = new InputStreamReader(JsonUtils.class.getResourceAsStream(jsonFilePath));
    }

    /**
     * Method used to create a java object from a json file.
     *
     * @param objectToCreate - specified dynamic object (POJO format)
     * @return Plain old Java Object from the JSON file
     */
    public Object createObjectFromJsonFile(Object objectToCreate) {
        gson = new GsonBuilder().create();

        return gson.fromJson(reader, objectToCreate.getClass());

    }

    public Object[] createArrayOfObjectsFromJsonFile(Object[] objectToCreate) {
        gson = new GsonBuilder().create();
        return gson.fromJson(reader, objectToCreate.getClass());

    }
}
