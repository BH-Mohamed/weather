package com.mattel.mymattel.di

//ACL : DO NOT REMOVE THIS COMMENT

import android.content.Context
import com.google.android.gms.tasks.Task
import com.mattel.mymattel.commons.AppPreferences
import com.mattel.mymattel.data.api.*
import com.mattel.mymattel.data.repository.*
import com.mattel.mymattel.domain.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Singleton

//IMPORT

@InstallIn(SingletonComponent::class)
@Module
object RepoModule {



//ACL : DO NOT REMOVE THIS COMMENT
    @Singleton
    @Provides
    fun provideConfigRepository(
       api: ConfigApi,
       pref : AppPreferences,
       listener : MutableStateFlow<Boolean>,
       @ApplicationContext  context: Context
    ) : IConfigRepository = ConfigRepository(api,pref,listener,context)

  @Singleton
    @Provides
    fun provideAuthRepository(
      firebaseToken : Task<String>,
      api: UserApi,
      pref : AppPreferences,
      listener : MutableStateFlow<Boolean>,
      confRepo : IConfigRepository,
      @ApplicationContext  context: Context

    ) : IUserRepository = UserRepository(firebaseToken,api, pref,listener , confRepo,context)

    @Singleton
    @Provides
    fun provideLineRepository(
      api : LineApi,
      pref : AppPreferences,
      confRepo : IConfigRepository,
      @ApplicationContext  context: Context
  ) : ILineRepository = LineRepository(api,pref,confRepo,context,)

    @Singleton
    @Provides
    fun provideBookingLineRepository(
       api : BookingLineApi,
      pref : AppPreferences,
       confRepo : IConfigRepository,
       @ApplicationContext  context: Context
    ) : IBookingLineRepository = BookingLineRepository(
      api, pref, confRepo, context
    )

    @Singleton
    @Provides
    fun provideFacturesRepository(
        api: FacturesApi,
        pref : AppPreferences,
        confRepo : IConfigRepository,
        @ApplicationContext  context: Context
    ) : IFacturesRepository = FacturesRepository(api,pref,confRepo,context)

    @Singleton
    @Provides
    fun provideProductRepository(
      api: ProductApi,
      confRepo : IConfigRepository,
      @ApplicationContext  context: Context
    ) : IProductRepository = ProductRepository(api,confRepo,context)

  @Singleton
    @Provides
    fun provideComplaintRepository(
        api : ComplaintApi,
        pref : AppPreferences,
        confRepo : IConfigRepository,
        @ApplicationContext  context: Context

        ) : IComplaintRepository = ComplaintRepository(api,pref,confRepo,context)

  @Singleton
    @Provides
    fun provideTransferRepository(
      @ApplicationContext  context: Context,
      transferApi: TransferApi,
      confRepo : IConfigRepository,
      productApi : ProductApi
  ) : ITransferRepository = TransferRepository(transferApi,productApi,confRepo,context)

  @Singleton
    @Provides
    fun provideServiceRepository(
      serviceApi: ServiceApi,
      confRepo : IConfigRepository,
      @ApplicationContext  context: Context,

      ) : IServiceRepository = ServiceRepository(serviceApi,context,confRepo)

    @Singleton
    @Provides
    fun provideRechargeRepository(
      rechargeApi: RechargeApi,
      pref : AppPreferences,
      confRepo : IConfigRepository,
      @ApplicationContext  context: Context,
    ) : IRechargeRepository = RechargeRepository(
      rechargeApi,pref,confRepo,context
    )

    @Singleton
    @Provides
    fun provideNotificationRepository(
        rechargeApi: NotificationApi,
        confRepo : IConfigRepository,
        @ApplicationContext  context: Context,
    ) : INotificationRepository = NotificationRepository(
        rechargeApi,confRepo,context
    )

//END

}
