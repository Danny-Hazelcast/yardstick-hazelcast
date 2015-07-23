/*
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package org.yardstickframework.hazelcast;

import com.hazelcast.cache.impl.HazelcastServerCachingProvider;
import com.hazelcast.client.*;
import com.hazelcast.client.cache.impl.HazelcastClientCachingProvider;
import com.hazelcast.core.*;
import com.hazelcast.instance.HazelcastInstanceProxy;
import org.yardstickframework.*;


import javax.cache.CacheManager;
import javax.cache.spi.CachingProvider;
import java.util.*;
import java.util.concurrent.*;

import static org.yardstickframework.BenchmarkUtils.*;

/**
 * Abstract class for Hazelcast benchmarks.
 */
public abstract class HazelcastAbstractMapBenchmark extends HazelcastAbstractBenchmark {

    private final String mapName;
    protected IMap<Object, Object> map;

    protected HazelcastAbstractMapBenchmark(String mapName) {
        this.mapName = mapName;
    }

    /** {@inheritDoc} */
    @Override public void setUp(BenchmarkConfiguration cfg) throws Exception {
        super.setUp(cfg);

        map = hazelcast().getMap(mapName);
        assert map != null;
    }


    /** {@inheritDoc} */
    @Override public void tearDown() throws Exception {
        map.clear();
        super.tearDown();
    }
}
