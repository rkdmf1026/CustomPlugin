package com.github.rkdmf1026.customplugin.mvvm.template.classes

fun createViewModel(
    packageName: String,
    className: String
) = """
package $packageName
import androidx.lifecycle.ViewModel
class ${className}ViewModel() : ViewModel() {
}
""".trimIndent()