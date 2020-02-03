<?php
/**
 * Created by PhpStorm.
 * User: liu
 * Date: 2019-02-16
 * Time: 00:23
 */
class Solution {

	/**
	 * @param String $num1
	 * @param String $num2
	 * @return String
	 */
	function addStrings($num1, $num2) {
		$int1 = new BigInt();
		$int2 = new BigInt();
		$int1->initFromString($num1);
		$int2->initFromString($num2);
		return $int1->addString($int2)->__toString();
	}
}

class BigInt
{
	public $bits = [];

	public function initFromString(string $num)
	{
		$len = strlen($num);
		$start = true;
		for ($i = 0; $i < $len; $i++) {
			$v = (int)$num[$i];
			if ($start && $v === 0) {
				continue;
			}
			$start = false;
			$this->bits[] = $v;
		}
		$this->bits = array_reverse($this->bits);
	}

	public function __toString()
	{
		while ($this->bits[count($this->bits)-1] === 0) {
			unset($this->bits[count($this->bits)-1]);
		}
		if (empty($this->bits)) {
			return '0';
		}
		return implode('', array_reverse($this->bits));
	}

	public function addString(BigInt $int2)
	{
		$bits = [];
		$len1 = count($this->bits);
		$len2 = count($int2->bits);
		$len = max($len1, $len2);
		for ($i = 0; $i < $len; $i++) {
			if (!isset($bits[$i])) {
				$bits[$i] = 0;
			}if (!isset($bits[$i + 1])) {
				$bits[$i + 1] = 0;
			}
			$bits[$i] += ($this->bits[$i] ?? 0) + ($int2->bits[$i] ?? 0);
			$bits[$i + 1] += (int)($bits[$i] / 10);
			$bits[$i] %= 10;
		}
		$int3 = new static();
		$int3->bits = $bits;
		return $int3;
	}
}

$s = new Solution();
echo $s->addStrings('1', '9');
