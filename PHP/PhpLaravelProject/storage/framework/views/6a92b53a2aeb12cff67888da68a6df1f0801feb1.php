<?php $__env->startSection('content'); ?>
<div class="container">
    <div class="table-responsive table-cart">
        <table class="table table-striped table-hover table-bordered">
            <thead>
                <tr>
                    <th>Imatge</th>
                    <th>Producte</th>
                    <th>Preu</th>
                    <th>Quantitat</th>
                    <th>Subtotal</th>
                    <th>Treure</th>
                </tr>
            </thead>
            <tbody>
                <?php if(count($cart)): ?>
                    <p><a href="<?php echo e(route('cart-trash')); ?>" class="btn btn-danger">Buidar Cistella<i class="fa fa-trash"></i></a></p>
                    <?php $__currentLoopData = $cart; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $item): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                        <tr>
                            <td><img src="<?php echo e($item->image); ?>"></td>
                            <td><?php echo e($item->name); ?></td>
                            <td><?php echo e(number_format($item->price,2)); ?> €</td>
                            <td>
                                <input type="number" min="1" max="100" value="<?php echo e($item->quantity); ?>" id ="product_<?php echo e($item->id); ?>">
                                <a href="#" class="btn btn-warning btn-update-item" data-href="<?php echo e(route('cart-update', $item->slug)); ?>" data-id = "<?php echo e($item->id); ?>"><i class="fa fa-refresh"></i></a>
                            </td>
                            <td><?php echo e(number_format($item->price * $item->quantity, 2)); ?> €</td>
                            <td><a href="<?php echo e(route('cart-delete', $item->slug)); ?>" class="btn btn-danger"><i class="fa fa-remove"></i></a></td>
                        </tr>
                    <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
                    <a href="<?php echo e(route('home')); ?>" class="btn btn-primary"><i class="fa fa-chevron-circle-left"></i>Seguir comprant</a>
                    <a href="#" class="btn btn-primary"><i class="fa fa-chevron-circle-right"></i>Continuar</a>
                <?php else: ?>
                    <h3><span class="label label-danger">La cistella està buida</span></h3>
                <?php endif; ?>
            </tbody>
        </table>
        <hr><h3><span class="btn btn-success">Total: <?php echo e(number_format($total, 2)); ?> €</span></h3>
    </div>
</div>
<?php $__env->stopSection(); ?>
<?php echo $__env->make('store.template', array_except(get_defined_vars(), array('__data', '__path')))->render(); ?>