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

package org.jetbrains.jet.codegen.intrinsics;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.asm4.Type;
import org.jetbrains.asm4.commons.InstructionAdapter;
import org.jetbrains.jet.codegen.ExpressionCodegen;
import org.jetbrains.jet.codegen.StackValue;
import org.jetbrains.jet.codegen.state.GenerationState;
import org.jetbrains.jet.lang.psi.JetExpression;

import java.util.List;

import static org.jetbrains.jet.codegen.AsmUtil.comparisonOperandType;

/**
 * @author alex.tkachman
 */
public class CompareTo implements IntrinsicMethod {
    @Override
    public StackValue generate(
            ExpressionCodegen codegen,
            InstructionAdapter v,
            @NotNull Type expectedType,
            @Nullable PsiElement element,
            @Nullable List<JetExpression> arguments,
            StackValue receiver,
            @NotNull GenerationState state
    ) {
        assert arguments != null;
        JetExpression argument = arguments.get(0);
        Type type = comparisonOperandType(receiver.type, codegen.expressionType(argument));

        receiver.put(type, v);
        codegen.gen(argument, type);

        if (type == Type.BYTE_TYPE || type == Type.SHORT_TYPE || type == Type.CHAR_TYPE) {
            v.sub(Type.INT_TYPE);
        }
        else if (type == Type.INT_TYPE) {
            v.invokestatic("jet/runtime/Intrinsics", "compare", "(II)I");
        }
        else if (type == Type.LONG_TYPE) {
            v.invokestatic("jet/runtime/Intrinsics", "compare", "(JJ)I");
        }
        else if (type == Type.FLOAT_TYPE) {
            v.invokestatic("java/lang/Float", "compare", "(FF)I");
        }
        else if (type == Type.DOUBLE_TYPE) {
            v.invokestatic("java/lang/Double", "compare", "(DD)I");
        }
        else {
            throw new UnsupportedOperationException();
        }
        return StackValue.onStack(Type.INT_TYPE);
    }
}
