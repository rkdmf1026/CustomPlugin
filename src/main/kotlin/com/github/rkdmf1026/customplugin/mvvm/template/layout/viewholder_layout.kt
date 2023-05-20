package com.github.rkdmf1026.customplugin.mvvm.template.layout

fun createViewHolderLayout() = """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:bind="http://schemas.android.com/tools"
    xmlns:tools="http://schemas.android.com/tools">
    <data>
    </data>
    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="48dp">
    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
""".trimIndent()