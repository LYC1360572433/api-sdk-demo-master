package com.lyc.apisdkdemo.controller;

import com.lyc.apisdk.client.ApiClient;
import com.lyc.apisdk.exception.ApiException;
import com.lyc.apisdk.model.params.HoroscopeParams;
import com.lyc.apisdk.model.params.IpInfoParams;
import com.lyc.apisdk.model.params.RandomWallpaperParams;
import com.lyc.apisdk.model.params.WeatherParams;
import com.lyc.apisdk.model.request.HoroscopeRequest;
import com.lyc.apisdk.model.request.IpInfoRequest;
import com.lyc.apisdk.model.request.WeatherRequest;
import com.lyc.apisdk.service.ApiService;
import com.lyc.easyweb.common.BaseResponse;
import com.lyc.easyweb.common.ResultUtils;
import com.lyc.easyweb.exception.BusinessException;
import com.lyc.apisdk.model.request.RandomWallpaperRequest;
import com.lyc.apisdk.model.response.LoveResponse;
import com.lyc.apisdk.model.response.PoisonousChickenSoupResponse;
import com.lyc.apisdk.model.response.RandomWallpaperResponse;
import com.lyc.apisdk.model.response.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 */
@RequestMapping("/invoke")
@RestController
@Slf4j
public class InvokeController {
    @Resource
    private ApiService apiService;


    /**
     * 随机毒鸡汤
     *
     * @return {@link PoisonousChickenSoupResponse}
     */
    @GetMapping("/getPoisonousChickenSoup")
    public PoisonousChickenSoupResponse getPoisonousChickenSoup() {
        ApiClient apiClient = new ApiClient("75e642bbef18faf80966b8f657e763bc", "0be1404ce26779d00cbb333a04267ade");
        PoisonousChickenSoupResponse poisonousChickenSoup = null;
        try {

            poisonousChickenSoup = apiService.getPoisonousChickenSoup(apiClient);
            System.out.println("poisonousChickenSoup = " + poisonousChickenSoup);
        } catch (ApiException e) {
            log.error(e.getMessage());
        }
        return poisonousChickenSoup;
    }


    /**
     * 随机毒鸡汤
     *
     * @return {@link PoisonousChickenSoupResponse}
     */
    @GetMapping("/getPoisonousChickenSoupKey")
    public PoisonousChickenSoupResponse getPoisonousChickenSoupKey(ApiClient apiClient) {
        PoisonousChickenSoupResponse poisonousChickenSoup = null;
        try {
            poisonousChickenSoup = apiService.getPoisonousChickenSoup(apiClient);
            System.out.println("poisonousChickenSoup = " + poisonousChickenSoup);
        } catch (ApiException e) {
            log.error(e.getMessage());
        }
        return poisonousChickenSoup;
    }

    /**
     * 获取毒鸡汤未设置密钥
     *
     * @return {@link BaseResponse}<{@link PoisonousChickenSoupResponse}>
     */
    @GetMapping("/getPoisonousChickenSoupNotSetKey")
    public BaseResponse<PoisonousChickenSoupResponse> getPoisonousChickenSoupNotSetKey() {
        PoisonousChickenSoupResponse poisonousChickenSoup = null;
        try {
            poisonousChickenSoup = apiService.getPoisonousChickenSoup();
            System.out.println("poisonousChickenSoup = " + poisonousChickenSoup);
        } catch (ApiException e) {
            throw new com.lyc.easyweb.exception.BusinessException(e.getCode(), e.getMessage());
        }
        return ResultUtils.success(poisonousChickenSoup);
    }

    /**
     * 随机情话
     *
     * @return {@link BaseResponse}<{@link LoveResponse}>
     */
    @GetMapping("/loveTalk/easyWeb")
    public BaseResponse<LoveResponse> getLoveTalkEasyWeb() {
        LoveResponse loveResponse;
        try {
            loveResponse = apiService.randomLoveTalk();
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return ResultUtils.success(loveResponse);
    }

    @GetMapping("/loveTalk")
    public LoveResponse getLoveTalk() {
        LoveResponse loveResponse;
        try {
            loveResponse = apiService.randomLoveTalk();
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return loveResponse;
    }

    @GetMapping("/loveTalk/setKey")
    public LoveResponse getLoveTalkSetKey() {
        LoveResponse loveResponse;
        try {
            ApiClient apiClient = new ApiClient("b73e61ed6e6300f1c069ee354e9e98e6", "5e8d7f6090e8eebc3dbe089737fbaf28");
            loveResponse = apiService.randomLoveTalk(apiClient);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return loveResponse;
    }

    /**
     * 获取星座运势
     *
     * @param horoscopeParams 星座参数
     * @return {@link BaseResponse}<{@link ResultResponse}>
     */
    @GetMapping("/getHoroscopeEasyWeb")
    public BaseResponse<ResultResponse> getHoroscopeEasyWeb(HoroscopeParams horoscopeParams) {
        ResultResponse horoscope;
        try {
            HoroscopeRequest horoscopeRequest = new HoroscopeRequest();
            horoscopeRequest.setRequestParams(horoscopeParams);
            horoscope = apiService.horoscope(horoscopeRequest);
        } catch (ApiException e) {
            throw new com.lyc.easyweb.exception.BusinessException(e.getCode(), e.getMessage());
        }
        return ResultUtils.success(horoscope);
    }

    @GetMapping("/getHoroscope")
    public ResultResponse getHoroscope(HoroscopeParams horoscopeParams) {
        ResultResponse horoscope;
        try {
            HoroscopeRequest horoscopeRequest = new HoroscopeRequest();
            horoscopeRequest.setRequestParams(horoscopeParams);
            horoscope = apiService.horoscope(horoscopeRequest);
        } catch (ApiException e) {
            throw new com.lyc.easyweb.exception.BusinessException(e.getCode(), e.getMessage());
        }
        return horoscope;
    }

    @GetMapping("/getHoroscope/setKey")
    public ResultResponse getHoroscopeSetKey(HoroscopeParams horoscopeParams) {
        ResultResponse horoscope;
        ApiClient apiClient = new ApiClient("7052a8594339a519e0ba5eb04a267a60", "d8d6df60ab209385a09ac796f1dfe3e1");
        try {
            HoroscopeRequest horoscopeRequest = new HoroscopeRequest();
            horoscopeRequest.setRequestParams(horoscopeParams);
            horoscope = apiService.horoscope(apiClient, horoscopeRequest);
        } catch (ApiException e) {
            throw new com.lyc.easyweb.exception.BusinessException(e.getCode(), e.getMessage());
        }
        return horoscope;
    }

    /**
     * 获取ip信息
     * <p>
     * // * @param ipInfoParams ip信息参数
     *
     * @return {@link BaseResponse}<{@link ResultResponse}>
     */
    @GetMapping("/ipInfo/easyWeb")
    public BaseResponse<ResultResponse> getIpInfoEasyWeb(ApiClient apiClient, IpInfoParams ipInfoParams) {
        ResultResponse resultResponse;
        try {
            IpInfoRequest ipInfoRequest = new IpInfoRequest();
            ipInfoRequest.setRequestParams(ipInfoParams);
            resultResponse = apiService.getIpInfo(apiClient, ipInfoRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return ResultUtils.success(resultResponse);
    }

    @GetMapping("/ipInfo/toEasyWeb")
    public BaseResponse<ResultResponse> getIpInfoEasyWeb(IpInfoParams ipInfoParams) {
        ResultResponse resultResponse;
        try {
            IpInfoRequest ipInfoRequest = new IpInfoRequest();
            ipInfoRequest.setRequestParams(ipInfoParams);
            resultResponse = apiService.getIpInfo(ipInfoRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return ResultUtils.success(resultResponse);
    }

    @GetMapping("/ipInfo")
    public ResultResponse getIpInfo(IpInfoParams ipInfoParams) {
        ApiClient apiClient = new ApiClient("7052a8594339a519e0ba5eb04a267a60", "d8d6df60ab209385a09ac796f1dfe3e1");
        ResultResponse resultResponse;
        try {
            IpInfoRequest ipInfoRequest = new IpInfoRequest();
            ipInfoRequest.setRequestParams(ipInfoParams);
            resultResponse = apiService.getIpInfo(apiClient, ipInfoRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return resultResponse;
    }

    /**
     * 获取天气信息
     *
     * @param weatherParams ip信息参数
     * @return {@link BaseResponse}<{@link ResultResponse}>
     */
    @GetMapping("/weatherInfo/EasyWeb")
    public BaseResponse<ResultResponse> getWeatherInfoEasyWeb(WeatherParams weatherParams) {
        ResultResponse resultResponse;
        try {
            WeatherRequest weatherRequest = new WeatherRequest();
            weatherRequest.setRequestParams(weatherParams);
            resultResponse = apiService.getWeatherInfo(weatherRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return ResultUtils.success(resultResponse);
    }

    @GetMapping("/weatherInfo")
    public ResultResponse getWeatherInfo(WeatherParams weatherParams) {
        ResultResponse resultResponse;
        try {
            WeatherRequest weatherRequest = new WeatherRequest();
            weatherRequest.setRequestParams(weatherParams);
            resultResponse = apiService.getWeatherInfo(weatherRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return resultResponse;
    }

    @GetMapping("/weatherInfo/setKey")
    public ResultResponse getWeatherInfoSetKey(WeatherParams weatherParams) {
        ResultResponse resultResponse;
        ApiClient apiClient = new ApiClient("7052a8594339a519e0ba5eb04a267a60", "d8d6df60ab209385a09ac796f1dfe3e1");
        try {
            WeatherRequest weatherRequest = new WeatherRequest();
            weatherRequest.setRequestParams(weatherParams);
            resultResponse = apiService.getWeatherInfo(apiClient, weatherRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return resultResponse;
    }

    @GetMapping("/randomWallpaper/setKey")
    public RandomWallpaperResponse getRandomWallpaperSetKey(RandomWallpaperParams randomWallpaperParams) {
        RandomWallpaperResponse resultResponse;
        ApiClient apiClient = new ApiClient("7052a8594339a519e0ba5eb04a267a60", "d8d6df60ab209385a09ac796f1dfe3e1");
        try {
            RandomWallpaperRequest randomWallpaperRequest = new RandomWallpaperRequest();
            randomWallpaperRequest.setRequestParams(randomWallpaperParams);
            resultResponse = apiService.getRandomWallpaper(apiClient, randomWallpaperRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return resultResponse;
    }

    @GetMapping("/randomWallpaper")
    public RandomWallpaperResponse getRandomWallpaper(RandomWallpaperParams randomWallpaperParams) {
        RandomWallpaperResponse resultResponse;
        try {
            RandomWallpaperRequest randomWallpaperRequest = new RandomWallpaperRequest();
            randomWallpaperRequest.setRequestParams(randomWallpaperParams);
            resultResponse = apiService.getRandomWallpaper(randomWallpaperRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return resultResponse;
    }

    @GetMapping("/randomWallpaper/easyWeb")
    public BaseResponse<RandomWallpaperResponse> getRandomWallpaperEasyWeb(RandomWallpaperParams randomWallpaperParams) {
        RandomWallpaperResponse resultResponse;
        try {
            RandomWallpaperRequest randomWallpaperRequest = new RandomWallpaperRequest();
            randomWallpaperRequest.setRequestParams(randomWallpaperParams);
            resultResponse = apiService.getRandomWallpaper(randomWallpaperRequest);
        } catch (ApiException e) {
            throw new BusinessException(e.getCode(), e.getMessage());
        }
        return ResultUtils.success(resultResponse);
    }
}
