package com.github.rkdmf1026.customplugin.mvvm.template.classes

fun createRecyclerAdapter(
    packageName: String,
    className: String
) = """
package $packageName
import androidx.recyclerview.widget.RecyclerView
class ${className}RecyclerAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
}
""".trimIndent()