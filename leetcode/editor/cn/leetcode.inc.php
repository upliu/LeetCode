<?php

class TreeNode
{
    public $val;

    /**
     * @var TreeNode
     */
    public $left;

    /**
     * @var TreeNode
     */
    public $right;

    public function __construct($value)
    {
        $this->val = $value;
    }

    public static function build($nums = []): \TreeNode
    {
        $queue = new SplQueue();
        $root = new TreeNode($nums[0]);
        $queue->enqueue($root);
        $queue->enqueue($root);
        $count = 0;
        $len = count($nums);
        for ($i = 1; $i < $len; $i++) {
            $count++;
            $p = $queue->dequeue();
            if ($nums[$i] === null) {
                continue;
            }
            $node = new TreeNode($nums[$i]);
            if (($count & 1) === 1) { // 奇数
                $p->left = $node;
            } else {
                $p->right = $node;
            }
            $queue->enqueue($node);
            $queue->enqueue($node);
        }
        return $root;
    }

    /**
     * 获取树的高度
     */
    public function getHeight(): int
    {
        $a = $this->left ? $this->left->getHeight() : 0;
        $b = $this->right ? $this->right->getHeight() : 0;
        return 1 + $a + $b;
    }

    /**
     * 前序遍历
     * @param TreeNode $root
     * @param TreeNode $startNode
     */
    public function preOrder($startNode = null)
    {
        if (!$startNode) $startNode = $this;
        echo $this->val, ' ';
        if ($this->left) $this->left->preOrder($startNode);
        if ($this->right) $this->right->preOrder($startNode);
        if ($startNode === $this) {
            echo "\n";
        }
    }

    /**
     * 中序遍历
     * @param TreeNode $root
     * @param TreeNode $startNode
     */
    public function inOrder($startNode = null)
    {
        if (!$startNode) $startNode = $this;
        if ($this->left) $this->left->inOrder($startNode);
        echo $this->val, ' ';
        if ($this->right) $this->right->inOrder($startNode);
        if ($startNode === $this) {
            echo "\n";
        }
    }

    /**
     * 后序遍历
     * @param TreeNode $root
     * @param TreeNode $startNode
     */
    public function postOrder($startNode = null)
    {
        if (!$startNode) $startNode = $this;
        if ($this->left) $this->left->postOrder($startNode);
        if ($this->right) $this->right->postOrder($startNode);
        echo $this->val, ' ';
        if ($startNode === $this) {
            echo "\n";
        }
    }
}
