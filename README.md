## HeiPermission
---

Android M 动态权限解决方案，Let You Fly！

### 动态图（相信你会 Star的）

![](img/1.gif)
### Sample 

在Activity中：

	首先需要检测权限的 Activity extends PermissionActivity

	checkPermission(new CheckPermListener() {
                    @Override
                    public void superPermission() {
                       TODO : 需要权限去完成的功能
                    }
                },R.string.camera, Manifest.permission.CAMERA);

在Fragment中：
   
	 首先Fragment依存的 Activity extends PermissionActivit

	((PermissionActivity)getActivity()).checkPermission(
		new PermissionActivity.CheckPermListener() {
            @Override
            public void superPermission() {
                 TODO : 需要权限去完成的功能
            }
        },R.string.camera, Manifest.permission.CAMERA);


## 感谢开源库

***[EasyPermissions](https://github.com/googlesamples/easypermissions)***

### 联系作者
邮箱:forjrking@sina.com
