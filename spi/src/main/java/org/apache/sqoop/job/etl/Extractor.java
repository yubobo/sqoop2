/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.sqoop.job.etl;

import org.apache.sqoop.common.ImmutableContext;
import org.apache.sqoop.job.io.DataWriter;

/**
 * This allows connector to extract data from a source system
 * based on each partition.
 */
public abstract class Extractor<ConnectionConfiguration, JobConfiguration> {

  public abstract void run(ImmutableContext context,
                           ConnectionConfiguration connectionConfiguration,
                           JobConfiguration jobConfiguration,
                           Partition partition,
                           DataWriter writer);

  /**
   * Return the number of rows read by the last call to
   * {@linkplain Extractor#run(org.apache.sqoop.common.ImmutableContext, java.lang.Object, java.lang.Object, org.apache.sqoop.job.etl.Partition, org.apache.sqoop.job.io.DataWriter) }
   * method. This method returns only the number of rows read in the last call,
   * and not a cumulative total of the number of rows read by this Extractor
   * since its creation. If no calls were made to the run method, this method's
   * behavior is undefined.
   *
   * @return the number of rows read by the last call to
   * {@linkplain Extractor#run(org.apache.sqoop.common.ImmutableContext, java.lang.Object, java.lang.Object, org.apache.sqoop.job.etl.Partition, org.apache.sqoop.job.io.DataWriter) }
   */
  public abstract long getRowsRead();

}
