fun isBalanced(root: TreeNode?): Boolean = getDepth(root) != -1

fun getDepth(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    val leftDepth = getDepth(root.left)
    if (leftDepth == -1) {
        return -1
    }
    val rightDeath = getDepth(root.right)
    if (rightDeath == -1) {
        return -1
    }
    if (Math.abs(leftDepth - rightDeath) > 1) {
        return -1
    }
    return 1 + Math.max(leftDepth, rightDeath)
}


fun main(args: Array<String>) {
    
}



