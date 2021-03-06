/*
 * -\-\-
 * Dataproc Java Submitter
 * --
 * Copyright (C) 2016 Spotify AB
 * --
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * -/-/-
 */
package com.spotify.dataproc;

import com.google.api.services.dataproc.model.Cluster;
import com.google.api.services.dataproc.model.ListClustersResponse;

import java.io.IOException;
import java.util.List;

class Clusters {

  private final DataprocClient client;

  Clusters(final DataprocClient client) {
    this.client = client;
  }

  List<Cluster> list() throws IOException {
    ListClustersResponse listClustersResponse = client.dataproc().projects().regions().clusters()
        .list(client.getProjectId(), client.getRegion())
        .execute();

    return listClustersResponse.getClusters();
  }

  Cluster get(final String name) throws IOException {
    return client.dataproc().projects().regions().clusters()
        .get(client.getProjectId(), client.getRegion(), name)
        .execute();
  }
}
