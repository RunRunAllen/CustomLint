package com.example.lintjava.detector;


import com.android.annotations.Nullable;
import com.android.ddmlib.Log;
import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.JavaContext;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;
import com.intellij.psi.JavaElementVisitor;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiMethodCallExpression;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.uast.UCallExpression;
import org.jetbrains.uast.UExpression;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("UnstableApiUsage")
public class SampleCodeDetector extends Detector implements Detector.UastScanner {

    public static final Issue ISSUE = Issue.create(
            "ShortUniqueId",
            "测试简介",
            "测试测试详情",
            Category.CORRECTNESS,
            6,
            Severity.ERROR,
            new Implementation(
                    SampleCodeDetector.class,
                    Scope.JAVA_FILE_SCOPE));

    @Nullable
    @Override
    public List<String> getApplicableMethodNames() {
        return Collections.singletonList("getIdentifier");
    }

    @Override
    public void visitMethodCall(@NotNull JavaContext context, @NotNull UCallExpression node, @NotNull PsiMethod method) {
        Log.i("haha", "====name==" + method.getClass().getName() + "====method==" + method.getClass().getSimpleName());
        Log.i("haha", "=====method====" + method.getName() + "===node==" + node.getValueArguments().get(0));
        Log.i("haha", "===node==" + node.getClass().getSimpleName());
        if (context.getEvaluator().isMemberInClass(method, "android.content.res.Resources")) {
            UExpression uExpression = node.getValueArguments().get(0);
            context.report(ISSUE, method, context.getLocation(node), "错误的方法");
        }
    }

    @Override
    public void visitMethod(@NotNull JavaContext context, @org.jetbrains.annotations.Nullable JavaElementVisitor visitor
            , @NotNull PsiMethodCallExpression call, @NotNull PsiMethod method) {
        super.visitMethod(context, visitor, call, method);
    }
}