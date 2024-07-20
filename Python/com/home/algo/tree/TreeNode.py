

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __str__(self):
        return 'val={0}, left=({1}), right=({2})'.format(self.val, self.left, self.right)

    @staticmethod
    def create_tree_node(input_list):
        if not input_list:
            return None
        n = iter(input_list)
        tree = TreeNode(next(n))
        fringe = [tree]
        while True:
            head = fringe.pop(0)
            if not head:
                continue
            try:
                left_val = next(n)
                if left_val is not None:
                    head.left = TreeNode(left_val)
                fringe.append(head.left)
                right_val = next(n)
                if right_val is not None:
                    head.right = TreeNode(right_val)
                fringe.append(head.right)
            except StopIteration:
                break
        return tree
