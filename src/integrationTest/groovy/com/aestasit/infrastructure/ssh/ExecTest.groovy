/*
 * Copyright (C) 2011-2015 Aestas/IT
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aestasit.infrastructure.ssh

import org.junit.Test

class ExecTest extends BaseIntegrationTest {

  @Test
  void testSimple() {
    engine.remoteSession {
      exec('uname -a')
      exec('date')
      exec('hostname')
      exec {
        prefix = "sudo sh -c '"
        suffix = "'"
        escapeCharacters = ['"', "'", '\\', '/']
        command = 'printf "%s\n%s\n" test rest'
      }
    }
  }

}
