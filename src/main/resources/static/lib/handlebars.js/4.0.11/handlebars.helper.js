Handlebars.registerHelper({
    //格式化时间
    'prettifyDate': function (timestamp) {
        var format = 'YYYY-MM-DD';
        if (arguments.length > 2) {
            format = arguments[1];
        }
        if (timestamp) {
            return moment(new Date(timestamp)).format(format);
        } else {
            return '';
        }
    },
    //格式化数字默认空为''
    'prettifyNumber': function (number) {
        var format = '0.00', zero = true;
        if (arguments.length > 2) {
            format = arguments[1];
        }
        if (arguments.length > 3) {
            zero = arguments[2];
        }

        return (zero ? number != null : !!number) ? numeral(number).format(format) : '';

    },
    //字符去空格
    'prettifyStr': function (s) {
        return s && s.replace(/\s/g, " ");
        ;

    },
    //格式化数字默认空为0
    'prettifyPositive': function (number) {
        var format = '0.00', zero = true;
        if (arguments.length > 2) {
            format = arguments[1];
        }
        if (arguments.length > 3) {
            zero = arguments[2];
        }

        return (zero ? number != null && number > 0 : !!number) ? numeral(number).format(format) : '0';

    },
    //减
    'subtract': function (number1, number2) {
        var format = '0.00';
        if (arguments.length > 3) {
            format = arguments[2];
        }
        var number = number1 - number2;
        return number ? numeral(number).format(format) : '';
    },
    //加
    'computeAdd': function () {
        var big = 0;
        try {
            var len = arguments.length - 1;
            for (var i = 0; i < len; i++) {
                if (arguments[i]) {
                    big = eval(big + "+" + arguments[i]);
                }
            }
        } catch (e) {
            throw new Error('Handlerbars Helper "computeAdd" can not deal with wrong expression:' + arguments);
        }
        return big;
    },
    "eq": function (v1, v2, options) {
        if (v1 == v2) {
            return options.fn(this);
        } else {
            return options.inverse(this);
        }
    },
    "compare": function (v1, v2, options) {
        if (v1 > v2) {
            return options.fn(this);
        } else {
            return options.inverse(this);
        }
    }
});