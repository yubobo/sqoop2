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
package org.apache.sqoop.client.shell;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.OptionBuilder;
import org.apache.sqoop.client.core.Constants;
import org.apache.sqoop.client.request.JobRequest;
import org.apache.sqoop.model.MJob;
import org.apache.sqoop.validation.Status;

import static org.apache.sqoop.client.shell.ShellEnvironment.*;

/**
 * Handles disabling of a job object.
 */
public class EnableJobFunction extends SqoopFunction {

  private JobRequest jobRequest;

  @SuppressWarnings("static-access")
  public EnableJobFunction() {
    this.addOption(OptionBuilder
      .withDescription(resourceString(Constants.RES_PROMPT_JOB_ID))
      .withLongOpt(Constants.OPT_JID)
      .hasArg()
      .create('j'));
  }

  public Object executeFunction(CommandLine line) {
    if (!line.hasOption(Constants.OPT_JID)) {
      printlnResource(Constants.RES_ARGS_JID_MISSING);
      return null;
    }

    if (jobRequest == null) {
      jobRequest = new JobRequest();
    }

    client.enableJob(getLong(line, Constants.OPT_JID), true);

    return null;
  }
}
