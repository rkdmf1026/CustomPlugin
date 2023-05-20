package com.github.rkdmf1026.customplugin.mvvm.recyclerview

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import com.github.rkdmf1026.customplugin.extension.save
import com.github.rkdmf1026.customplugin.extension.toSnakeCase
import com.github.rkdmf1026.customplugin.mvvm.template.classes.*
import com.github.rkdmf1026.customplugin.mvvm.template.layout.createRecyclerActivityLayout
import com.github.rkdmf1026.customplugin.mvvm.template.layout.createViewHolderLayout
import com.github.rkdmf1026.customplugin.listeners.MyFrameStateListener.Companion.projectInstance
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.psi.PsiManager

fun RecipeExecutor.mvvmRecyclerActivitySetup(
    moduleData: ModuleTemplateData,
    packageName: String,
    className: String,
    activityLayoutName: String,
) {
    val (projectData, _, _, manifestOut) = moduleData
    val project = projectInstance ?: return

    addAllKotlinDependencies(moduleData)

    val virtualFiles = ProjectRootManager.getInstance(project).contentSourceRoots
    val virtSrc = virtualFiles.firstOrNull { it.path.contains("app/src/main/java") } ?: return
    val virtRes = virtualFiles.firstOrNull { it.path.contains("app/src/main/res") } ?: return
    val directorySrc = PsiManager.getInstance(project).findDirectory(virtSrc) ?: return
    val directoryRes = PsiManager.getInstance(project).findDirectory(virtRes) ?: return

    val activityClass = "${className}Activity".replaceFirstChar { it }
    val adapterClass = "${className}RecyclerAdatper".replaceFirstChar { it }
    val viewHolderClass = "${className}ItemViewHolder".replaceFirstChar { it }
    val viewModelClass = "${className}ViewModel".replaceFirstChar { it }

    mergeXml(
        manifestTemplateXml(packageName, "${className}Activity"),
        manifestOut.resolve("AndroidManifest.xml")
    )

    createRecyclerActivity(packageName, className, activityLayoutName, projectData)
        .save(directorySrc, packageName, "$activityClass.kt")

    createRecyclerAdapter(packageName, className)
        .save(directorySrc, "$packageName.adapter", "$adapterClass.kt")

    createViewHolder(packageName, className)
        .save(directorySrc, "$packageName.viewHolder", "$viewHolderClass.kt")

    createViewModel(packageName, className)
        .save(directorySrc, "$packageName.viewModel", "$viewModelClass.kt")

    createRecyclerActivityLayout(packageName, className)
        .save(directoryRes, "layout", "${activityLayoutName}.xml")

    createViewHolderLayout()
        .save(directoryRes, "layout", "item_${className.toSnakeCase()}.xml")
}