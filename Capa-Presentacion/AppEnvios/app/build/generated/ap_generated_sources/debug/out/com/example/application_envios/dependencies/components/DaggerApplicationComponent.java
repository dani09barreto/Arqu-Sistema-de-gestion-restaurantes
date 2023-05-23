// Generated by Dagger (https://dagger.dev).
package com.example.application_envios.dependencies.components;

import com.example.application_envios.activities.BasicActivity;
import com.example.application_envios.activities.BasicActivity_MembersInjector;
import com.example.application_envios.dependencies.modules.AlertsModule;
import com.example.application_envios.dependencies.modules.AlertsModule_ProvideAlertHelperFactory;
import com.example.application_envios.dependencies.modules.LocationModule;
import com.example.application_envios.dependencies.modules.LocationModule_ProvideLocationServiceFactory;
import com.example.application_envios.dependencies.modules.PermissionModule;
import com.example.application_envios.dependencies.modules.PermissionModule_ProvidePermissionHelperFactory;
import com.example.application_envios.dependencies.modules.RouterGoogleAPIModule;
import com.example.application_envios.dependencies.modules.RouterGoogleAPIModule_ProvideRouterGoogleARIServiceFactory;
import com.example.application_envios.services.RouterGoogleAPIService;
import com.example.application_envios.utils.AlertsHelper;
import com.example.application_envios.utils.PermissionHelper;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerApplicationComponent {
  private DaggerApplicationComponent() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private AlertsModule alertsModule;

    private PermissionModule permissionModule;

    private LocationModule locationModule;

    private RouterGoogleAPIModule routerGoogleAPIModule;

    private Builder() {
    }

    public Builder alertsModule(AlertsModule alertsModule) {
      this.alertsModule = Preconditions.checkNotNull(alertsModule);
      return this;
    }

    public Builder permissionModule(PermissionModule permissionModule) {
      this.permissionModule = Preconditions.checkNotNull(permissionModule);
      return this;
    }

    public Builder locationModule(LocationModule locationModule) {
      this.locationModule = Preconditions.checkNotNull(locationModule);
      return this;
    }

    public Builder routerGoogleAPIModule(RouterGoogleAPIModule routerGoogleAPIModule) {
      this.routerGoogleAPIModule = Preconditions.checkNotNull(routerGoogleAPIModule);
      return this;
    }

    public ApplicationComponent build() {
      if (alertsModule == null) {
        this.alertsModule = new AlertsModule();
      }
      if (permissionModule == null) {
        this.permissionModule = new PermissionModule();
      }
      Preconditions.checkBuilderRequirement(locationModule, LocationModule.class);
      if (routerGoogleAPIModule == null) {
        this.routerGoogleAPIModule = new RouterGoogleAPIModule();
      }
      return new ApplicationComponentImpl(alertsModule, permissionModule, locationModule, routerGoogleAPIModule);
    }
  }

  private static final class ApplicationComponentImpl implements ApplicationComponent {
    private final LocationModule locationModule;

    private final ApplicationComponentImpl applicationComponentImpl = this;

    private Provider<PermissionHelper> providePermissionHelperProvider;

    private Provider<AlertsHelper> provideAlertHelperProvider;

    private Provider<RouterGoogleAPIService> provideRouterGoogleARIServiceProvider;

    private ApplicationComponentImpl(AlertsModule alertsModuleParam,
        PermissionModule permissionModuleParam, LocationModule locationModuleParam,
        RouterGoogleAPIModule routerGoogleAPIModuleParam) {
      this.locationModule = locationModuleParam;
      initialize(alertsModuleParam, permissionModuleParam, locationModuleParam, routerGoogleAPIModuleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final AlertsModule alertsModuleParam,
        final PermissionModule permissionModuleParam, final LocationModule locationModuleParam,
        final RouterGoogleAPIModule routerGoogleAPIModuleParam) {
      this.providePermissionHelperProvider = DoubleCheck.provider(PermissionModule_ProvidePermissionHelperFactory.create(permissionModuleParam));
      this.provideAlertHelperProvider = DoubleCheck.provider(AlertsModule_ProvideAlertHelperFactory.create(alertsModuleParam));
      this.provideRouterGoogleARIServiceProvider = DoubleCheck.provider(RouterGoogleAPIModule_ProvideRouterGoogleARIServiceFactory.create(routerGoogleAPIModuleParam));
    }

    @Override
    public void inject(BasicActivity activity) {
      injectBasicActivity(activity);
    }

    private BasicActivity injectBasicActivity(BasicActivity instance) {
      BasicActivity_MembersInjector.injectPermissionHelper(instance, providePermissionHelperProvider.get());
      BasicActivity_MembersInjector.injectAlertsHelper(instance, provideAlertHelperProvider.get());
      BasicActivity_MembersInjector.injectLocationService(instance, LocationModule_ProvideLocationServiceFactory.provideLocationService(locationModule));
      BasicActivity_MembersInjector.injectRouterGoogleAPIService(instance, provideRouterGoogleARIServiceProvider.get());
      return instance;
    }
  }
}
