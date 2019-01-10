$(document).ready(function() {

    $("#h3-1,#h3-2,.dot").hover(function() {
        $(this).siblings(".line-1").addClass("hover-1");
    }, function() {
        $(this).siblings(".line-1").removeClass("hover-1");
    });

    $('.panel-collapse').on('show.bs.collapse', function () {
        $(this).siblings('.panel-heading').addClass('active');
        $(this).siblings('.panel-heading').children('h4').children('a').addClass('activeAccordion');
    });

    $('.panel-collapse').on('hide.bs.collapse', function () {
        $(this).siblings('.panel-heading').removeClass('active');
        $(this).siblings('.panel-heading').children('h4').children('a').removeClass('activeAccordion');
    });

    var url = $("#video").attr('src');

    $("#myModal").on('hide.bs.modal', function(){
        $("#video").attr('src', '');
    });

    $("#myModal").on('show.bs.modal', function(){
        $("#video").attr('src', url);
    });

    $('.dropdown a.droping').on("click", function(e){
        $(this).next('ul').toggle();
        e.stopPropagation();
        e.preventDefault();
    });

    $(window).scroll(function () {

        if ($(window).scrollTop() > $('header').height()) {
            $('nav').addClass('sticky');
        } else {
            $('nav').removeClass('sticky');
        }
    });

    loadDoc();

   $(window).on('scroll.scroll1', function myScroll1() {

        scrollPosition = $(this).scrollTop();

        if (scrollPosition >= 350) {

            $('#progress-bar-1').css('width', '80%');
            $('#progress-bar-2').css('width', '60%');
            $('#progress-bar-3').css('width', '70%');
            $('#progress-bar-4').css('width', '100%');
            $('#progress-bar-5').css('width', '40%');

            $('#span-1').css('margin', '0');
            $('#span-2').css('margin', '0');
            $('#span-3').css('margin', '0');
            $('#span-4').css('margin', '0');
            $('#span-5').css('margin', '0');

            $('.count-1').each(function () {
                $(this).prop('Counter',0).animate({
                    Counter: $(this).text()
                }, {
                    duration: 3000,
                    easing: 'swing',
                    step: function (now) {
                        $(this).text(Math.ceil(now));
                    }
                });
            });

            $(window).off("scroll.scroll1", myScroll1);
        }

    });

    $(window).on('scroll.scroll2', function myScroll2() {

        scrollPosition = $(this).scrollTop();

        if (scrollPosition >= 1625) {

            $('.count').each(function () {
                $(this).prop('Counter',0).animate({
                    Counter: $(this).text()
                }, {
                    duration: 3000,
                    easing: 'swing',
                    step: function (now) {
                        $(this).text(Math.ceil(now));
                    }
                });
            });

            $(window).off("scroll.scroll2", myScroll2);

        }

    });

    $(function() {
        $('.imagesOpen').on('click', function() {
            $('.enlargeImageModalSource').attr('src', $(this).attr('src'));
            $('#enlargeImageModal').modal('show');
        });
    });

});


var myScroll1 = function () {
    $(window).off("scroll", myScroll1)
};


var locations = [
    ['Your location description 2', -12.0425461, -77.02686812],
    ['Your sub location description 1', -12.03950319, -77.03545119],
    ['Your sub location description 2', -12.05136286, -77.02394562],
];

function initMap() {
    var myLatLng = {lat: -12.0425461, lng: -77.02686812};

    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 14,
        center: myLatLng
    });

    var count;

    for (count = 0; count < locations.length; count++) {
        new google.maps.Marker({
            position: new google.maps.LatLng(locations[count][1], locations[count][2]),
            map: map,
            icon: 'images/Icon.png',
            title: locations[count][0]
        });
    }
}

let a1 = document.getElementById("a1");
let a2 = document.getElementById("a2");
let a3 = document.getElementById("a3");
let plan = document.getElementById("Plan");
plan.setAttribute("class", "row");

function loadDoc() {
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", "Pricing-plans.json", true);
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let obj = JSON.parse(xhttp.responseText);
            obj.forEach(function (a) {
                let length = obj[0].benefits.length;
                let table = document.createElement("table");
                table.className += "col-md-4 col-sm-6 col-xs-12 marg-l-r-10";
                table.className += " margin-top-50";
                plan.appendChild(table);
                let th = document.createElement("thead");
                if (a.active === true) {
                    th.className += "price-head-active";
                }
                let div = document.createElement("div");
                div.className += "hexagon";
                div.className += " center-block";
                th.appendChild(div);
                table.appendChild(th);
                let span1 = document.createElement("span");
                span1.className += "price";
                span1.innerHTML = a.users.number;
                div.appendChild(span1);
                let span2 = document.createElement("span");
                span2.className += "per";
                div.appendChild(span2);
                let monthly = document.createTextNode("MONTHLY");
                span2.appendChild(monthly);
                let headRow = th.insertRow();
                let headInfo = headRow.insertCell();
                headInfo.innerHTML = a.title;
                headInfo.appendChild(div);
                headInfo.className += "price-head";
                let tbody = document.createElement("tbody");
                tbody.className += "font-sans-serif";
                table.appendChild(tbody);
                let benefits = a.benefits;
                benefits.forEach(function (b) {
                    let row = tbody.insertRow();
                    let info = row.insertCell();
                    info.className = "price-info";
                    if (b.status === 1) {
                        info.className += " tru";
                        info.className += " price-plan-color";
                        info.innerHTML = b.name;
                    }
                    if (b.status === 0) {
                        info.className += " fals";
                        info.className += " price-plan-color";
                        info.innerHTML = b.name;
                    }
                });
                let row = tbody.insertRow();
                let info = row.insertCell();
                info.setAttribute("class", "price-info");
                let btn = document.createElement("button");
                btn.setAttribute("class", "price-btn");
                let img = document.createElement("span");
                img.className += "price-btn-icon ";
                img.className += "fas ";
                img.className += "fa-shopping-cart";
                btn.appendChild(img);
                let txt = document.createTextNode("  Order Now");
                btn.appendChild(txt);
                info.appendChild(btn);
            });
        }
    };
    xhttp.send();
}
