/*
 * Copyright 2010-2012 JetBrains s.r.o.
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

package org.jetbrains.k2js.test.semantics;

import org.jetbrains.k2js.test.MultipleFilesTranslationTest;

/**
 * @author Pavel Talanov
 */
public final class MultiFileTest extends MultipleFilesTranslationTest {

    public MultiFileTest() {
        super("multiFile/");
    }

    public void testFunctionsVisibleFromOtherFile() throws Exception {
        checkFooBoxIsTrue("functionsVisibleFromOtherFile");
    }

    //TODO: fails on centos-1 build agent, can't reproduce
    public void TODO_testClassesInheritedFromOtherFile() throws Exception {
        checkFooBoxIsTrue("classesInheritedFromOtherFile");
    }

    public void testClassOfTheSameNameInAnotherPackage() throws Exception {
        checkFooBoxIsTrue("classOfTheSameNameInAnotherPackage");
    }
}
