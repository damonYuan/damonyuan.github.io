module SymmetricTree
    TreeNode = Class.new do
        attr_accessor :val, :left, :right
        def initialize(val)    
            @val = val
            @left, @right = nil, nil
        end
    end

    class << self
        def is_symmetric(root) 
            return true if root.nil?
            mirror(root.left, root.right)
        end

        def mirror(a, b)
            return a == b if (a == nil || b == nil)
            a.val == b.val && mirror(a.left, b.right) && mirror(a.right, b.left)
        end
    end
end

def test
    root = SymmetricTree::TreeNode.new 1
    root.left = SymmetricTree::TreeNode.new 2
    root.right = SymmetricTree::TreeNode.new 2
    isSymmetric = SymmetricTree.is_symmetric root
    puts "isSymmetric #{isSymmetric}"
end

test
