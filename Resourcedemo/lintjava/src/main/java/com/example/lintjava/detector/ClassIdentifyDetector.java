package com.example.lintjava.detector;


import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.ClassContext;
import com.android.tools.lint.detector.api.ClassScanner;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.GradleContext;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.ParameterNode;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

@SuppressWarnings("UnstableApiUsage")
public class ClassIdentifyDetector extends Detector implements ClassScanner {

    public static final Issue ISSUE = Issue.create(
            "classIdentifierId",
            "class测试",
            "class测试详情",
            Category.CORRECTNESS,
            6,
            Severity.ERROR,
            new Implementation(
                    ClassIdentifyDetector.class,
                    EnumSet.of(Scope.ALL_CLASS_FILES)))
            .setEnabledByDefault(false)
            .setAndroidSpecific(true);

    @Nullable
    @Override
    public List<String> getApplicableCallNames() {
        return Collections.singletonList("getIdentifier");
    }

    @Nullable
    @Override
    public List<String> getApplicableCallOwners() {
        return super.getApplicableCallOwners();
    }

    @Override
    public void checkCall(@NotNull ClassContext context, @NotNull ClassNode classNode, @NotNull MethodNode method, @NotNull MethodInsnNode call) {
        if (call.name.equals("getIdentifier")) {
            context.getLocation(classNode);
            context.report(ISSUE, context.getLocation(classNode), "错误的方法哈哈哈");
        }
    }

    @Override
    public void checkMethodCall(@NotNull GradleContext context, @NotNull String statement, @Nullable String parent, @NotNull Map<String, String> namedArguments, @NotNull List<String> unnamedArguments, @NotNull Object cookie) {
        super.checkMethodCall(context, statement, parent, namedArguments, unnamedArguments, cookie);
    }

}