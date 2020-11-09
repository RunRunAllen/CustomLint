package com.example.lintjava;

import com.android.tools.lint.client.api.IssueRegistry;
import com.android.tools.lint.detector.api.ApiKt;
import com.android.tools.lint.detector.api.Issue;
import com.example.lintjava.detector.ClassIdentifyDetector;
import com.example.lintjava.detector.SampleCodeDetector;
import com.example.lintjava.detector.TextStringInCodeDetector;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;


@SuppressWarnings("UnstableApiUsage")
public class CustomIssueRegistry extends IssueRegistry {

    @NotNull
    @Override
    public List<Issue> getIssues() {
        return Arrays.asList(
                SampleCodeDetector.ISSUE,
                TextStringInCodeDetector.ISSUE
                , ClassIdentifyDetector.ISSUE);
    }

    @Override
    public int getApi() {
        return ApiKt.CURRENT_API;
    }
}
