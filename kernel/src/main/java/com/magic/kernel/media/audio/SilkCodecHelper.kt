package com.magic.kernel.media.audio

import com.magic.kernel.MagicHooker

object SilkCodecHelper {

    init {
        System.load(MagicHooker.getApplicationLibsPath("com.magic.xmagichooker") + "/libsilk.so")
    }

    /**
     * silk编码初始化
     * @param sampleRate
     * @param bitRate
     * @param complexity 0 is lowest; 1 is medium and 2 is highest
     *
     * @return 0 success or fail
     */
    external fun silkEncI(sampleRate: Int, bitRate: Int, complexity: Int): Int

    /**
     * 开始编码
     * @param sourcePath pcm文件路径
     * @param destPath 解码后的slk文件路径
     * @param isTencent 是否是微信、qq、企业微信的silk编码格式
     *
     * @return 0 success or fail
     */
    external fun silkEnc(sourcePath: String, destPath: String, isTencent: Boolean): Int

    /**
     * 释放编码资源
     */
    external fun silkEncUi()

    /**
     * silk解码初始化
     * @param sampleRate
     *
     * @return 0 success or fail
     */
    external fun silkDecI(sampleRate: Int): Int

    /**
     * 开始解码
     * @param sourcePath silk文件路径
     * @param destPath 解码后的pcm文件路径
     *
     * @return 0 success or fail
     */
    external fun silkDec(sourcePath: String, destPath: String): Int

    /**
     * 释放解码资源
     */
    external fun silkDecUi()

    /**
     * 获取silk编解码框架的版本
     */
    external fun silkVersion(): String
}