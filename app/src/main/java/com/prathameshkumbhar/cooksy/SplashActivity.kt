package com.prathameshkumbhar.cooksy

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.prathameshkumbhar.cooksy.databinding.ActivitySplashBinding
import com.prathameshkumbhar.cooksy.utils.changeStatusBarColor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.cos
import kotlin.math.sin

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        changeStatusBarColor(window, this, R.color.olive_green)
        setContentView(binding.root)

        binding.cooksyLogo.translationZ = 0f
        binding.cooksyLogoV1.translationZ = 1f

        startCircularAnimationLoop(binding, this)
    }

}

//Below are the animations for the android (will make library for this)
/*private fun startCircularAnimationLoop(binding: ActivitySplashBinding, context: Context) {
val distance = 200f

binding.cooksyLogo.alpha = 1f
binding.cooksyLogoV1.alpha = 0f
binding.cooksyLogoV1.translationX = distance

val moveLeftToCenter = ObjectAnimator.ofFloat(binding.cooksyLogo, "translationX", -distance, 0f)
moveLeftToCenter.duration = 1000
moveLeftToCenter.interpolator = LinearInterpolator()

val fadeOutImage1 = ObjectAnimator.ofFloat(binding.cooksyLogo, "alpha", 1f, 0f)
fadeOutImage1.duration = 1000

val hideImage1Set = AnimatorSet()
hideImage1Set.playTogether(moveLeftToCenter, fadeOutImage1)

val moveRightToCenter =
    ObjectAnimator.ofFloat(binding.cooksyLogoV1, "translationX", distance, 0f)
moveRightToCenter.duration = 1000
moveRightToCenter.interpolator = LinearInterpolator()

val fadeOutImage2 = ObjectAnimator.ofFloat(binding.cooksyLogoV1, "alpha", 1f, 0f)
fadeOutImage2.duration = 1000

val showAndHideImage2Set = AnimatorSet()
showAndHideImage2Set.playTogether(moveRightToCenter, fadeOutImage2)

val fullAnimation = AnimatorSet()
fullAnimation.playSequentially(hideImage1Set, showAndHideImage2Set)

fullAnimation.addListener(object : Animator.AnimatorListener {
    override fun onAnimationStart(animation: Animator) {}

    override fun onAnimationEnd(animation: Animator) {
        binding.cooksyLogo.translationX = -distance
        binding.cooksyLogo.alpha = 1f
        binding.cooksyLogoV1.translationX = distance
        binding.cooksyLogoV1.alpha = 1f

        startCircularAnimationLoop(binding, context)
    }

    override fun onAnimationCancel(animation: Animator) {}
    override fun onAnimationRepeat(animation: Animator) {}
})

fullAnimation.start()
}*/


/*private fun startCircularAnimationLoop(binding: ActivitySplashBinding, context: Context) {
val distance = 200f

// Initially, show only ImageView1 and hide ImageView2
binding.cooksyLogo.alpha = 1f
binding.cooksyLogoV1.alpha = 0f
binding.cooksyLogoV1.translationX = distance

// ImageView1: Move from left to center, scale down, and rotate slightly as it fades out
val moveLeftToCenter = ObjectAnimator.ofFloat(binding.cooksyLogo, "translationX", -distance, 0f)
moveLeftToCenter.duration = 1000
moveLeftToCenter.interpolator = LinearInterpolator()

val fadeOutImage1 = ObjectAnimator.ofFloat(binding.cooksyLogo, "alpha", 1f, 0f)
fadeOutImage1.duration = 1000

val scaleDownImage1 = ObjectAnimator.ofFloat(binding.cooksyLogo, "scaleX", 1f, 0.8f)
val scaleDownImage1Y = ObjectAnimator.ofFloat(binding.cooksyLogo, "scaleY", 1f, 0.8f)
scaleDownImage1.duration = 1000
scaleDownImage1Y.duration = 1000

val rotateImage1 = ObjectAnimator.ofFloat(binding.cooksyLogo, "rotationY", 0f, 20f)
rotateImage1.duration = 1000

val image1ToBack = ObjectAnimator.ofFloat(binding.cooksyLogo, "translationZ", 0f, -30f)
image1ToBack.duration = 1000

val hideImage1Set = AnimatorSet()
hideImage1Set.playTogether(moveLeftToCenter, fadeOutImage1, scaleDownImage1, scaleDownImage1Y, rotateImage1, image1ToBack)

// ImageView2: Move from right to center, scale down, and rotate slightly as it fades out
val moveRightToCenter = ObjectAnimator.ofFloat(binding.cooksyLogoV1, "translationX", distance, 0f)
moveRightToCenter.duration = 1000
moveRightToCenter.interpolator = LinearInterpolator()

val fadeOutImage2 = ObjectAnimator.ofFloat(binding.cooksyLogoV1, "alpha", 1f, 0f)
fadeOutImage2.duration = 1000

val scaleDownImage2 = ObjectAnimator.ofFloat(binding.cooksyLogoV1, "scaleX", 1f, 0.8f)
val scaleDownImage2Y = ObjectAnimator.ofFloat(binding.cooksyLogoV1, "scaleY", 1f, 0.8f)
scaleDownImage2.duration = 1000
scaleDownImage2Y.duration = 1000

val rotateImage2 = ObjectAnimator.ofFloat(binding.cooksyLogoV1, "rotationY", -20f, 0f)
rotateImage2.duration = 1000

val image2ToFront = ObjectAnimator.ofFloat(binding.cooksyLogoV1, "translationZ", -30f, 0f)
image2ToFront.duration = 1000

val showAndHideImage2Set = AnimatorSet()
showAndHideImage2Set.playTogether(moveRightToCenter, fadeOutImage2, scaleDownImage2, scaleDownImage2Y, rotateImage2, image2ToFront)

// Full animation: ImageView1 disappears, ImageView2 comes in front, then disappears
val fullAnimation = AnimatorSet()
fullAnimation.playSequentially(hideImage1Set, showAndHideImage2Set)

fullAnimation.addListener(object : Animator.AnimatorListener {
    override fun onAnimationStart(animation: Animator) {}

    override fun onAnimationEnd(animation: Animator) {
        // Reset the positions and alpha for both images
        binding.cooksyLogo.translationX = -distance
        binding.cooksyLogo.translationZ = 0f
        binding.cooksyLogo.alpha = 1f
        binding.cooksyLogo.scaleX = 1f
        binding.cooksyLogo.scaleY = 1f
        binding.cooksyLogo.rotationY = 0f

        binding.cooksyLogoV1.translationX = distance
        binding.cooksyLogoV1.translationZ = -30f
        binding.cooksyLogoV1.alpha = 1f
        binding.cooksyLogoV1.scaleX = 1f
        binding.cooksyLogoV1.scaleY = 1f
        binding.cooksyLogoV1.rotationY = 0f

        // Restart the loop
        startCircularAnimationLoop(binding, context)
    }

    override fun onAnimationCancel(animation: Animator) {}
    override fun onAnimationRepeat(animation: Animator) {}
})

fullAnimation.start()
}*/


/*private fun startCircularAnimationLoop(binding: ActivitySplashBinding, context: Context) {
val centerX = binding.root.width / 2f
val centerY = binding.root.height / 2f
val radius = 200f // Radius of the circular path
val duration = 2000L // Duration for one complete revolution

// Animation for Sun 1
val sun1Animator = ValueAnimator.ofFloat(0f, 360f)
sun1Animator.duration = duration
sun1Animator.repeatCount = ValueAnimator.INFINITE

sun1Animator.addUpdateListener { animation ->
    val angle = Math.toRadians(animation.animatedValue.toString().toDouble())
    val sun1X = (centerX + radius * Math.cos(angle)).toFloat()
    val sun1Y = (centerY + radius * Math.sin(angle)).toFloat()

    binding.cooksyLogo.translationX = sun1X
    binding.cooksyLogo.translationY = sun1Y

    // Scale to simulate depth
    val scale = 1 + 0.5f * Math.sin(angle).toFloat() // Scale effect
    binding.cooksyLogo.scaleX = scale
    binding.cooksyLogo.scaleY = scale

    // Fade in/out effect
    binding.cooksyLogo.alpha = (0.5f + 0.5f * sin(angle)).toFloat()
}

// Animation for Sun 2
val sun2Animator = ValueAnimator.ofFloat(0f, 360f)
sun2Animator.duration = duration
sun2Animator.repeatCount = ValueAnimator.INFINITE

sun2Animator.addUpdateListener { animation ->
    val angle = Math.toRadians(animation.animatedValue.toString().toDouble())
    val sun2X = (centerX + radius * Math.cos(angle + Math.PI)).toFloat() // Offset by 180 degrees
    val sun2Y = (centerY + radius * Math.sin(angle + Math.PI)).toFloat()

    binding.cooksyLogoV1.translationX = sun2X
    binding.cooksyLogoV1.translationY = sun2Y

    // Scale to simulate depth
    val scale = 1 + 0.5f * Math.sin(angle).toFloat() // Scale effect
    binding.cooksyLogoV1.scaleX = scale
    binding.cooksyLogoV1.scaleY = scale

    // Fade in/out effect
    binding.cooksyLogoV1.alpha = (0.5f + 0.5f * sin(angle)).toFloat()
}

// Start both animations
sun1Animator.start()
sun2Animator.start()
}*/


/*private fun startCircularAnimationLoop(binding: ActivitySplashBinding, context: Context) {
val screenWidth = binding.root.width
val distance = screenWidth.toFloat() // Full width of the screen

// Initial setup for images
binding.cooksyLogo.translationX = distance
binding.cooksyLogoV1.translationX = distance
binding.cooksyLogo.alpha = 1f
binding.cooksyLogoV1.alpha = 0f

// Animator for Image 1 (moving from right to left)
val moveImage1 = ObjectAnimator.ofFloat(binding.cooksyLogo, "translationX", distance, 0f, -distance)
moveImage1.duration = 3000
moveImage1.interpolator = LinearInterpolator()

// Scale Image 1 as it moves, making it larger towards the center and smaller as it moves away
val scaleUpImage1 = ObjectAnimator.ofFloat(binding.cooksyLogo, "scaleX", 1f, 1.2f, 1f)
val scaleYImage1 = ObjectAnimator.ofFloat(binding.cooksyLogo, "scaleY", 1f, 1.2f, 1f)
val fadeOutImage1 = ObjectAnimator.ofFloat(binding.cooksyLogo, "alpha", 1f, 1f, 0f)
scaleUpImage1.duration = 3000
scaleYImage1.duration = 3000
fadeOutImage1.duration = 3000

// AnimatorSet for Image 1 (combine translation, scaling, and fading out)
val image1Set = AnimatorSet()
image1Set.playTogether(moveImage1, scaleUpImage1, scaleYImage1, fadeOutImage1)

// Animator for Image 2 (moving from right to left, after Image 1 reaches center)
val moveImage2 = ObjectAnimator.ofFloat(binding.cooksyLogoV1, "translationX", distance, 0f, -distance)
moveImage2.duration = 3000
moveImage2.interpolator = LinearInterpolator()

// Scale Image 2 in the same way as Image 1
val scaleUpImage2 = ObjectAnimator.ofFloat(binding.cooksyLogoV1, "scaleX", 1f, 1.2f, 1f)
val scaleYImage2 = ObjectAnimator.ofFloat(binding.cooksyLogoV1, "scaleY", 1f, 1.2f, 1f)
val fadeInOutImage2 = ObjectAnimator.ofFloat(binding.cooksyLogoV1, "alpha", 0f, 1f, 0f)
scaleUpImage2.duration = 3000
scaleYImage2.duration = 3000
fadeInOutImage2.duration = 3000

// AnimatorSet for Image 2
val image2Set = AnimatorSet()
image2Set.playTogether(moveImage2, scaleUpImage2, scaleYImage2, fadeInOutImage2)

// Sequence the animations: Image 1 moves first, followed by Image 2
val fullAnimation = AnimatorSet()
fullAnimation.playSequentially(image1Set, image2Set)

// Loop the animations
fullAnimation.addListener(object : Animator.AnimatorListener {
    override fun onAnimationStart(animation: Animator) {}

    override fun onAnimationEnd(animation: Animator) {
        // Reset positions and alpha
        binding.cooksyLogo.translationX = distance
        binding.cooksyLogoV1.translationX = distance
        binding.cooksyLogo.alpha = 1f
        binding.cooksyLogoV1.alpha = 0f

        // Restart the loop
        startCircularAnimationLoop(binding, context)
    }

    override fun onAnimationCancel(animation: Animator) {}
    override fun onAnimationRepeat(animation: Animator) {}
})

// Start the animation loop
fullAnimation.start()
}*/


/*private fun startCircularAnimationLoop(binding: ActivitySplashBinding, context: Context) {
val centerX = binding.root.width / 2f
val centerY = binding.root.height / 2f
val radius = 200f // Radius of the circular path
val duration = 2000L // Duration for one complete revolution

// Animation for Sun 1 (cooksyLogo)
val sun1Animator = ValueAnimator.ofFloat(0f, 360f).apply {
    this.duration = duration
    repeatCount = ValueAnimator.INFINITE
    addUpdateListener { animation ->
        val angle = Math.toRadians(animation.animatedValue.toString().toDouble())
        val sun1X = (centerX + radius * Math.cos(angle)).toFloat()
        val sun1Y = (centerY + radius * Math.sin(angle)).toFloat()

        binding.cooksyLogo.translationX = sun1X
        binding.cooksyLogo.translationY = sun1Y

        // Scale to simulate depth, limited to a maximum of 1.2x original size
        val scale = 1 + 0.2f * Math.sin(angle).toFloat()
        binding.cooksyLogo.scaleX = scale
        binding.cooksyLogo.scaleY = scale

        // Fade in/out effect
        binding.cooksyLogo.alpha = (0.5f + 0.5f * Math.sin(angle)).toFloat()
    }
}

// Animation for Sun 2 (cooksyLogoV1)
val sun2Animator = ValueAnimator.ofFloat(0f, 360f).apply {
    this.duration = duration
    repeatCount = ValueAnimator.INFINITE
    addUpdateListener { animation ->
        val angle = Math.toRadians(animation.animatedValue.toString().toDouble())
        val sun2X = (centerX + radius * Math.cos(angle + Math.PI)).toFloat() // Offset by 180 degrees
        val sun2Y = (centerY + radius * Math.sin(angle + Math.PI)).toFloat()

        binding.cooksyLogoV1.translationX = sun2X
        binding.cooksyLogoV1.translationY = sun2Y

        // Scale to simulate depth, limited to a maximum of 1.2x original size
        val scale = 1 + 0.2f * Math.sin(angle).toFloat()
        binding.cooksyLogoV1.scaleX = scale
        binding.cooksyLogoV1.scaleY = scale

        // Fade in/out effect
        binding.cooksyLogoV1.alpha = (0.5f + 0.5f * Math.sin(angle)).toFloat()
    }
}

// Sequence the animations
sun1Animator.addListener(object : AnimatorListenerAdapter() {
    override fun onAnimationEnd(animation: Animator) {
        sun2Animator.start()
    }
})

sun2Animator.addListener(object : AnimatorListenerAdapter() {
    override fun onAnimationEnd(animation: Animator) {
        sun1Animator.start()
    }
})

// Start the first animation
sun1Animator.start()
}*/


/*private fun startCircularAnimationLoop(binding: ActivitySplashBinding, context: Context) {
val centerX = binding.root.width / 2f
val centerY = binding.root.height / 2f
val radius = 200f // Radius of the circular path
val duration = 2000L // Duration for one complete revolution

// Animation for both Sun 1 (cooksyLogo) and Sun 2 (cooksyLogoV1)
val animator = ValueAnimator.ofFloat(0f, 360f).apply {
    this.duration = duration
    repeatCount = ValueAnimator.INFINITE
    addUpdateListener { animation ->
        val angle = Math.toRadians(animation.animatedValue.toString().toDouble())

        // Calculate positions for cooksyLogo
        val sun1X = (centerX + radius * cos(angle)).toFloat()
        val sun1Y = (centerY + radius * sin(angle)).toFloat()
        binding.cooksyLogo.translationX = sun1X
        binding.cooksyLogo.translationY = sun1Y

        // Calculate positions for cooksyLogoV1 (offset by 180 degrees)
        val sun2X = (centerX + radius * cos(angle + Math.PI)).toFloat()
        val sun2Y = (centerY + radius * sin(angle + Math.PI)).toFloat()
        binding.cooksyLogoV1.translationX = sun2X
        binding.cooksyLogoV1.translationY = sun2Y

        // Scale to simulate depth, limited to a maximum of 1.2x original size
        val scale1 = 1 + 0.2f * sin(angle).toFloat()
        binding.cooksyLogo.scaleX = scale1
        binding.cooksyLogo.scaleY = scale1

        val scale2 = 1 + 0.2f * sin(angle + Math.PI).toFloat()
        binding.cooksyLogoV1.scaleX = scale2
        binding.cooksyLogoV1.scaleY = scale2

        // Fade in/out effect
        binding.cooksyLogo.alpha = (0.5f + 0.5f * sin(angle)).toFloat()
        binding.cooksyLogoV1.alpha = (0.5f + 0.5f * sin(angle + Math.PI)).toFloat()
    }
}

// Start the animation
animator.start()
}*/

private fun startCircularAnimationLoop(binding: ActivitySplashBinding, context: Context) {
    val centerX = binding.root.width / 2f
    val centerY = binding.root.height / 2f
    val radius = 200f // Radius of the circular path
    val duration = 4000L  // Duration for one complete revolution

    // Introduce phase differences between the logos (120 degrees or Math.PI/1.5 for three logos)
    val phaseDifference1 = 2 * Math.PI / 3 // 120 degrees offset for cooksyLogoV1
    val phaseDifference2 = 4 * Math.PI / 3 // 240 degrees offset for cooksyLogoV2

    // Animation for cooksyLogo, cooksyLogoV1, and cooksyLogoV2
    val animator = ValueAnimator.ofFloat(0f, 360f).apply {
        this.duration = duration
        repeatCount = ValueAnimator.INFINITE
        interpolator = LinearInterpolator() // Ensures smooth, continuous rotation without pausing
        addUpdateListener { animation ->
            val angle = Math.toRadians(animation.animatedValue.toString().toDouble())

            // Calculate positions for cooksyLogo
            val sun1X = (centerX + radius * cos(angle)).toFloat()
            val sun1Y = (centerY + radius * sin(angle)).toFloat()
            binding.cooksyLogo.translationX = sun1X
            binding.cooksyLogo.translationY = sun1Y

            // Calculate positions for cooksyLogoV1 (offset by phaseDifference1)
            val sun2X = (centerX + radius * cos(angle + phaseDifference1)).toFloat()
            val sun2Y = (centerY + radius * sin(angle + phaseDifference1)).toFloat()
            binding.cooksyLogoV1.translationX = sun2X
            binding.cooksyLogoV1.translationY = sun2Y

            // Calculate positions for cooksyLogoV2 (offset by phaseDifference2)
            val sun3X = (centerX + radius * cos(angle + phaseDifference2)).toFloat()
            val sun3Y = (centerY + radius * sin(angle + phaseDifference2)).toFloat()
            binding.cooksyLogoV2.translationX = sun3X
            binding.cooksyLogoV2.translationY = sun3Y

            // Scale to simulate depth
            val scale1 = 1 + 0.2f * sin(angle).toFloat()
            binding.cooksyLogo.scaleX = scale1
            binding.cooksyLogo.scaleY = scale1

            val scale2 = 1 + 0.2f * sin(angle + phaseDifference1).toFloat()
            binding.cooksyLogoV1.scaleX = scale2
            binding.cooksyLogoV1.scaleY = scale2

            val scale3 = 1 + 0.2f * sin(angle + phaseDifference2).toFloat()
            binding.cooksyLogoV2.scaleX = scale3
            binding.cooksyLogoV2.scaleY = scale3

            // Fade in/out effect
            binding.cooksyLogo.alpha = (0.5f + 0.5f * sin(angle)).toFloat()
            binding.cooksyLogoV1.alpha = (0.5f + 0.5f * sin(angle + phaseDifference1)).toFloat()
            binding.cooksyLogoV2.alpha = (0.5f + 0.5f * sin(angle + phaseDifference2)).toFloat()
        }
    }

    // Start the animation
    animator.start()

    // Use a coroutine to handle the delay and navigation
    CoroutineScope(Dispatchers.Main).launch {
        delay(5000L) // Wait for 5 seconds before stopping the animation

        // Stop the animation
        animator.cancel()

        // Hide other logos and show only cooksyLogo
        binding.cooksyLogoV1.isVisible = false
        binding.cooksyLogoV2.isVisible = false

        // Move cooksyLogo to the center of the screen
        binding.cooksyLogo.translationX = 0f
        binding.cooksyLogo.translationY = 0f
        binding.cooksyLogo.alpha = 1f // Make cooksyLogo fully visible

        // Wait for another 2 seconds before navigating to screen B
        delay(2000L)

        // Navigate to screen B (replace this with your actual navigation logic)
      /*  val intent = Intent(context, ScreenBActivity::class.java)
        context.startActivity(intent)*/
    }
}










