window.onload = function () {
    let wugui = document.getElementById("wugui");
    let chicken = document.getElementById("chicken");

    let currentTop = parseInt(window.getComputedStyle(wugui).top);
    let currentLeft = parseInt(window.getComputedStyle(wugui).left);

    document.getElementById("up").onclick = function () {
        currentTop -= 30;
        wugui.style.top = currentTop + "px";
        checkEat();
    }
    document.getElementById("left").onclick = function () {
        currentLeft -= 30;
        wugui.style.left = currentLeft + "px";
        checkEat();
    }
    document.getElementById("down").onclick = function () {
        currentTop += 30;
        wugui.style.top = currentTop + "px";
        checkEat();
    }
    document.getElementById("right").onclick = function () {
        currentLeft += 30;
        wugui.style.left = currentLeft + "px";
        checkEat();
    }

    function checkEat() {
        let wuguiRect = wugui.getBoundingClientRect();
        let chickenRect = chicken.getBoundingClientRect();

        if (
            wuguiRect.left < chickenRect.right &&
            wuguiRect.right > chickenRect.left &&
            wuguiRect.top < chickenRect.bottom &&
            wuguiRect.bottom > chickenRect.top
        ) {
            alert("吃鸡了");
            wugui.style.top = "200px"; // 直接设置CSS样式
            wugui.style.left = "100px"; // 直接设置CSS样式
            // 在这里更新currentTop和currentLeft，确保它们与实际DOM同步
            currentTop = 200;
            currentLeft = 100;
        }
    }
}