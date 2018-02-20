#!/bin/bash

#
# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

set -e

cd /home/hmc/product

parse_jvm_options() {
  if [ -f "$1" ]; then
    echo "$(grep "^-" "$1" | tr '\n' ' ')"
  fi
}
JAVA_OPTS="$(parse_jvm_options jvm.options)"


echo ${JAVA_OPTS}
echo $(echo ./*.jar | tr ' ' ':')
echo $1
echo $2

exec java ${JAVA_OPTS} -Dspring.profiles.active=$1 -jar $(echo ./*.jar | tr ' ' ':') com.ebay.hmc.service.Application --order=2

EXPOSE $2
