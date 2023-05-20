package com.github.rkdmf1026.customplugin.mvvm.template.classes

fun createViewHolder(
    packageName: String,
    className: String
) = """
package $packageName
import androidx.recyclerview.widget.RecyclerView
import net.deali.buyer.databinding.Item${className}Binding
    
class ${className}ItemViewHolder(val binding: Item${className}Binding)
 : RecyclerView.ViewHolder(binding.root)
""".trimIndent()