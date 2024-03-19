class ListNode:
    def __init__(self, value = 0, next = None):
        self.value = value
        self.next = next

    def __eq__(self, o: object) -> bool:
        this = self
        if o.__class__ != ListNode:
            return False
        while this is not None:
            if o is None:
                return False
            if o.value != this.value:
                return False
            this = this.next
            o = o.next
        return True

    def __str__(self):
        return f'(value={self.value}, next={self.next})'





