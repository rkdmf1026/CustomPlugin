package com.github.rkdmf1026.customplugin.mvvm.template.classes

fun manifestTemplateXml(packageName: String, activityClassName: String) = """
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:tools="http://schemas.android.com/tools"
package="net.deali.test">
    <application>
        <activity android:name="$packageName.$activityClassName"/>   
    </application>
</manifest>
        """