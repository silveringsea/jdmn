/**
 * Copyright 2016 Goldman Sachs.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.gs.dmn.feel.analysis.semantics.environment;

import com.gs.dmn.feel.analysis.semantics.type.StringType;
import com.gs.dmn.feel.analysis.syntax.ast.expression.function.PositionalSignature;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class EnvironmentTest {
    private EnvironmentFactory environmentFactory = DefaultDMNEnvironmentFactory.instance();

    @Test
    public void testLookupVariableDeclaration() throws Exception {
        Environment environment = environmentFactory.makeEnvironment();
        String name = "x";
        environment.addDeclaration(new VariableDeclaration(name, StringType.STRING));

        assertEquals("x", environment.lookupVariableDeclaration(name).getInputExpression());
    }

    @Test
    public void testLookupFunctionDeclaration() throws Exception {
        Environment environment = environmentFactory.makeEnvironment();

        String functionName = "date";
        assertEquals(functionName, environment.lookupFunctionDeclaration(functionName, new PositionalSignature(Arrays.asList(StringType.STRING))).getInputExpression());
    }
}