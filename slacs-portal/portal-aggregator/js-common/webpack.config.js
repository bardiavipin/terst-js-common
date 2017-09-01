var webpack = require('webpack');

var config = {
    context: __dirname + '/src', // `__dirname` is root of project and `src` is source
    entry: {
        app: './index.js',
    },
    output: {
        path: __dirname + '/dist', // `dist` is the destination
        filename: 'bundle.js'
    },
    module: {
        rules: [
            {
                test: /\.js$/, // Check for all js files
                exclude: /node_modules/,
                use: [{
                    loader: 'babel-loader',
                    options: { presets: ['es2015'] }
                }]
            }
        ]
    }
};


module.exports = config;