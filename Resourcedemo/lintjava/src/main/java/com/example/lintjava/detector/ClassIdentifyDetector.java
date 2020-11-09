package com.example.lintjava.detector;


import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.ClassContext;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

@SuppressWarnings("UnstableApiUsage")
public class ClassIdentifyDetector extends Detector implements Detector.ClassScanner {

    public static final Issue ISSUE = Issue.create(
            "classIdentifierId",
            "class测试",
            "class测试详情",
            Category.CORRECTNESS,
            6,
            Severity.ERROR,
            new Implementation(
                    ClassIdentifyDetector.class,
                    EnumSet.of(Scope.ALL_CLASS_FILES)));

    @Nullable
    @Override
    public List<String> getApplicableCallNames() {
        List<String> list = Collections.singletonList("getIdentifier");
        return list;
    }

    @Nullable
    @Override
    public List<String> getApplicableMethodNames() {
        List<String> list = Collections.singletonList("getIdentifier");
        return list;
    }

    @Override
    public void checkCall(@NotNull ClassContext context, @NotNull ClassNode classNode, @NotNull MethodNode method, @NotNull MethodInsnNode call) {
        String owner = call.owner;
        if (owner.startsWith("android.content.res.Resources")) {
            if (call.name.equals("getIdentifier")) {
                context.getLocation(classNode);
                context.report(ISSUE, context.getLocation(call), "错误的方法哈哈哈");
            }
        }

    }

}