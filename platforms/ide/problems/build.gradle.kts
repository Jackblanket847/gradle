/*
 * Copyright 2021 the original author or authors.
 *
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
 */

plugins {
    id("gradlebuild.distribution.api-java")
}

description = """Problem SPI implementations.
    |
    |This project contains the SPI implementations for the problem reporting infrastructure.
""".trimMargin()

dependencies {
    api(project(":problems-api"))

    implementation(libs.guava)
    implementation(libs.inject)

    implementation(project(":core-api"))
    implementation(project(":core"))
    implementation(project(":base-services"))
    implementation(project(":enterprise-operations")) {
        because("ExecuteTaskBuildOperationType is used in the problem reporting infrastructure")
    }

    integTestImplementation(project(":internal-testing"))
    integTestImplementation(testFixtures(project(":logging")))
    integTestDistributionRuntimeOnly(project(":distributions-full"))
}
