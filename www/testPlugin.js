var exec = require('cordova/exec');

exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'testPlugin', 'coolMethod', [arg0]);
};
exports.getViuAutherizationToken = function (arg0, success, error) {
    exec(success, error, 'testPlugin', 'getViuAutherizationToken', [arg0]);
};
