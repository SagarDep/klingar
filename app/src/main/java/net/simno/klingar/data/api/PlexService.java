/*
 * Copyright (C) 2016 Simon Norberg
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.simno.klingar.data.api;

import net.simno.klingar.BuildConfig;
import net.simno.klingar.data.api.model.DeviceContainer;
import net.simno.klingar.data.api.model.User;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

public interface PlexService {

  @SuppressWarnings("SameParameterValue")
  @Headers({
      "X-Plex-Platform: Android",
      "X-Plex-Provides: player",
      "X-Plex-Client-Identifier: 1337",
      "X-Plex-Version: " + BuildConfig.VERSION_NAME
  })
  @POST("/users/sign_in.xml")
  Observable<User> signIn(@Header("X-Plex-Product") String product,
                          @Header("X-Plex-Platform-Version") String platformVersion,
                          @Header("X-Plex-Device") String device,
                          @Header("X-Plex-Device-Name") String deviceName,
                          @Header("Authorization") String authorization);

  @GET("/pms/resources?includeHttps=1")
  Observable<DeviceContainer> resources();
}