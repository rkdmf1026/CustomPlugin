package com.github.rkdmf1026.customplugin.listeners

import com.intellij.ide.FrameStateListener
import com.intellij.openapi.components.service
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.WindowManager
import com.intellij.openapi.wm.impl.IdeFrameImpl

internal class MyFrameStateListener : FrameStateListener  {

    override fun onFrameActivated() {
        // 플러그인이 활성화된 프레임에서 실행될 코드
        val project = getProjectFromIdeFrame()
        projectInstance = project
        project?.service<MyFrameStateListener>()

        thisLogger().warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.")
    }

    override fun onFrameDeactivated() {
        // 프레임이 비활성화 될 때 실행될 코드
        projectInstance = null
        super.onFrameDeactivated()
    }

    private fun getProjectFromIdeFrame(): Project? {
        val frame = WindowManager.getInstance().getAllProjectFrames().firstOrNull() as? IdeFrameImpl
        return frame?.project
    }

    companion object {
        var projectInstance : Project? = null
    }
}
