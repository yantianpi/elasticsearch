/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.elasticsearch.protocol.xpack.ml;

import org.elasticsearch.common.xcontent.XContentParser;
import org.elasticsearch.protocol.xpack.ml.job.config.Job;
import org.elasticsearch.protocol.xpack.ml.job.config.JobTests;
import org.elasticsearch.test.AbstractXContentTestCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetJobResponseTests extends AbstractXContentTestCase<GetJobResponse> {

    @Override
    protected GetJobResponse createTestInstance() {

        int count = randomIntBetween(1, 5);
        List<Job.Builder> results = new ArrayList<>(count);
        for(int i = 0; i < count; i++) {
            results.add(JobTests.createRandomizedJobBuilder());
        }

        return new GetJobResponse(results, count);
    }

    @Override
    protected GetJobResponse doParseInstance(XContentParser parser) throws IOException {
        return GetJobResponse.fromXContent(parser);
    }

    @Override
    protected boolean supportsUnknownFields() {
        return false;
    }
}
