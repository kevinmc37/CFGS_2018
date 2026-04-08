<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title><?php echo $__env->yieldContent('title','La meva botiga Laravel'); ?></title>
        <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootswatch/4.0.0-beta.3/lumen/bootstrap.min.css">-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet"> 
        <link rel="stylesheet" href="<?php echo e(asset("css/main.css")); ?>">
    </head>
    <body>
        <?php echo $__env->make('store.partials.nav', array_except(get_defined_vars(), array('__data', '__path')))->render(); ?>
        <?php echo $__env->yieldContent('content'); ?>
        <?php echo $__env->make('store.partials.footer', array_except(get_defined_vars(), array('__data', '__path')))->render(); ?>
        <script src="<?php echo e(asset("js/pinterest_grid.js")); ?>"></script>
        <script>
        $(document).ready(function() {
            $('#products').pinterest_grid({
                no_columns: 4,
                padding_x: 10,
                padding_y: 10,
                margin_bottom: 50,
                single_column_breakpoint: 700
            });
            $(".btn-update-item").on('click', function(e){
		e.preventDefault();
		var id = $(this).data('id');
		var href = $(this).data('href');
		var quantity = $("#product_" + id).val();
		window.location.href = href + "/" + quantity;
            });
        });
        </script>
    </body>
</html>