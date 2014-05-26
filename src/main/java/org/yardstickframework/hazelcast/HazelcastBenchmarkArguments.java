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

import com.beust.jcommander.*;

/**
 * Input arguments for Hazelcast benchmarks.
 */
@SuppressWarnings({"UnusedDeclaration", "FieldCanBeLocal"})
public class HazelcastBenchmarkArguments {
    /** */
    @Parameter(names = {"-nn", "--nodeNumber"}, description = "Node number")
    private int nodes = 1;

    /** */
    @Parameter(names = {"-b", "--backups"}, description = "Backups")
    private int backups;

    @Parameter(names = {"-hzcfg", "--hzConfig"}, description = "Configuration file")
    private String hzCfg = "config/hazelcast-config.xml";

    /** */
    @Parameter(names = {"-sb", "--syncBackups"}, description = "Synchronous backups")
    private boolean syncBackups;

    /** */
    @Parameter(names = {"-cm", "--clientMode"}, description = "Client mode")
    private boolean clientMode;

    /** */
    @Parameter(names = {"-r", "--range"}, description = "Key range")
    private int range = 1_000_000;

    /**
     * @return Sync backups.
     */
    public boolean syncBackups() {
        return syncBackups;
    }

    /**
     * @return Client mode.
     */
    public boolean clientMode() {
        return clientMode;
    }

    /**
     * @return Backups.
     */
    public int backups() {
        return backups;
    }

    /**
     * @return Nodes.
     */
    public int nodes() {
        return nodes;
    }

    /**
     * @return Key range, from {@code 0} to this number.
     */
    public int range() {
        return range;
    }

    /**
     * @return Configuration file.
     */
    public String configuration() {
        return hzCfg;
    }

    /**
     * @return Short string.
     */
    public String parametersToString() {
        return "-nn=" + nodes + "-b=" + backups + "-sb=" + syncBackups + "-cm=" + clientMode;
    }

    /** {@inheritDoc} */
    @Override public String toString() {
        return "HazelcastBenchmarkArguments [" +
            "nodes=" + nodes +
            ", backups=" + backups +
            ", hzcfg='" + hzCfg + '\'' +
            ", syncBackups=" + syncBackups +
            ", clientMode=" + clientMode +
            ", range=" + range +
            ']';
    }
}